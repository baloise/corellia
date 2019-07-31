package ch.baloise.corellia.api.doc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

import javax.swing.text.html.Option;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A {@link ModelConverter} dedicated for enum using {@link JsonValue} annoation on a getter.
 * This is then used to create a specification for a enum in the form of a list of the enum's values as strings.
 */
public class JsonFormatObjectEnumConverter implements ModelConverter {

  private JsonPropertyDescriptionResolver jsonPropertyDescriptionResolver = new JsonPropertyDescriptionResolver(Json.mapper());

  @Override
  public Schema resolve(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
    if(type.isSchemaProperty()){
      JavaType _type = Json.mapper().constructType(type.getType());
      Class<?> cls = _type.getRawClass();
      boolean isApplicable = hasAnnotation(cls, JsonFormat.class) && ((JsonFormat)findMatchingAnnotation(cls, JsonFormat.class)).shape().equals(
          JsonFormat.Shape.OBJECT);
      if(_type.isEnumType() && isApplicable){
        @SuppressWarnings(value = "unchecked")
        Class<? extends Enum> enumClass = (Class<? extends Enum>)cls; // is enum
        Map<String, Object> enumValueMap = createEnumMap(enumClass);
        String desc = extractDescription(type);
        String appendix = createDescriptionAppendixFor(enumValueMap);
        StringSchema schema = createTheSchemaWith(desc + "\n"+appendix, enumValueMap.values().stream().map(it -> it.toString()).collect(
            Collectors.toList()).toArray(new String[0]));

        return schema;
      }
    }
    if(chain.hasNext()){
      return chain.next().resolve(type,context,chain);
    }else{
      return null;
    }
  }


  private  String extractDescription(AnnotatedType type){
    return jsonPropertyDescriptionResolver.resolveDescription(null, type.getCtxAnnotations(), null); // These null values are okay, as these params are not used.
  }


  private String createDescriptionAppendixFor(Map<String, Object> enumMap){
    StringBuilder sb = new StringBuilder();
    sb.append("Enum Value: Enum Name\n");
    enumMap.forEach((key, value) -> sb.append(value).append(": ").append(key).append("\n"));
    return sb.toString();
  }

  /**
   * Creates a {@link StringSchema} with given description and list of enum items to be set.
   * <br>
   * However, it is questionable whether this is approach is sustainable and re-usable in any other context than the given one.
   * For code-generators to work, it might be required to encode the enum instances as objects
   */
  private static StringSchema createTheSchemaWith(String description, String... enumItems){
    StringSchema schema = new StringSchema();
    Arrays.stream(enumItems).forEach(schema::addEnumItem);
    schema.description(description);
    return schema;
  }

  /* ================================ REFLECTION UTILS =========================================== */

  private static boolean hasAnnotation(Class<?> cls, Class<? extends Annotation> anCls){
    return Arrays.stream(cls.getAnnotations()).anyMatch(an -> an.annotationType().equals(anCls));
  }

  private static Optional<Method> findFirstJsonValueMethod(Class<?> cls){
    return Arrays.stream(cls.getDeclaredMethods()).filter(m -> hasAnnotation(m, JsonValue.class)).findFirst();
  }

  private static Annotation findMatchingAnnotation(Class<?> cls, Class<? extends Annotation> anCls){
    return Arrays.stream(cls.getAnnotations()).filter(an -> an.annotationType().equals(anCls)).findFirst().orElseThrow(() -> new IllegalArgumentException("The provided class does not have the expected annotation"));
  }

  private static boolean hasAnnotation(AccessibleObject object, Class<? extends Annotation> anCls){
    return Arrays.stream(object.getAnnotations()).anyMatch(an -> an.annotationType().equals(anCls));
  }

  /**
   * Creates a map of {@code enumName}/{@code value} tuples where {@code enumName} the name of an enum instance, found with {@link Enum#name()} and {@code value} the result of the method annotated with {@link JsonValue} is.
   * Obviously this requires the given class to be an enum with such a annotated enum
   * Otherwise an empty map is returned.
   */
  private static Map<String, Object> createEnumMap(Class<? extends Enum> enumCls){
    if(!enumCls.isEnum()){
      throw new IllegalArgumentException("No enum class");
    }
    Map<String, Object> map = new HashMap<>();
    Optional<Method> getter = findFirstJsonValueMethod(enumCls);
    getter.ifPresent(m -> {
      Arrays.stream(enumCls.getEnumConstants()).forEach(enumInstance -> {
        try {
          map.put(enumInstance.name(), m.invoke(enumInstance));
        }
        catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace(); // Could be ignored?
        }
      });
    });
    return map;
  }



}
