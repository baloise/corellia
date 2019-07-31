package ch.baloise.corellia.api.doc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A {@link ModelConverter} dedicated for enum using {@link JsonValue} annoation on a getter.
 * This is then used to create a specification for a enum in the form of ENUM_INSTANCE_NAME: VALUE.
 */
public class JsonFormatObjectEnumConverter implements ModelConverter {

  private JsonPropertyDescriptionResolver jsonPropertyDescriptionResolver = new JsonPropertyDescriptionResolver(Json.mapper());

  @Override
  public Schema resolve(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
    if(type.isSchemaProperty()){
      JavaType _type = Json.mapper().constructType(type.getType());
      if(_type.isEnumType()){
        Class<?> cls = _type.getRawClass();
        for(Annotation an : cls.getAnnotations()){
          if(an instanceof JsonFormat && ((JsonFormat)an).shape().equals(JsonFormat.Shape.OBJECT)){
            for( Method method: cls.getDeclaredMethods()){
              if(!method.getName().toLowerCase().startsWith("get")){
                continue;
              }
              if(hasAnnotation(method, JsonValue.class)){
                Map<String, Object> values = new HashMap<>();
                for(Object enumConstant : cls.getEnumConstants()){
                  Enum e = (Enum)enumConstant;
                  try {
                    values.put(e.name(), method.invoke(enumConstant));
                  }
                  catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace(); // Could be safely ignored, as the method shall exist and there is no security
                  }
                }
                /*
                // Alternative: create custom key-value pairs. However this is not very effektive.
                ObjectSchema objectSchema = new ObjectSchema();
                values.forEach((key, value) -> objectSchema.addEnumItemObject(value));
                return objectSchema;*/
                StringSchema stringSchema = new StringSchema();
//                values.forEach((key, value) -> stringSchema.addEnumItem(key + ": " + value));
                values.forEach((key, value) -> stringSchema.addEnumItem(value.toString()));
                String desc = jsonPropertyDescriptionResolver.resolveDescription(null, type.getCtxAnnotations(), null);
                StringBuilder sb = new StringBuilder();
                sb.append("Enum Value: Enum Name\n");
                values.forEach((key, value) -> sb.append(value).append(": ").append(key).append("\n"));
                stringSchema.description(desc+"\n"+sb.toString());
                return stringSchema;
              }
            }
          }
        }
      }
    }
    if(chain.hasNext()){
      return chain.next().resolve(type,context,chain);
    }else{
      return null;
    }
  }

  private static boolean hasAnnotation(AccessibleObject object, Class<? extends Annotation> anCls){
    for(Annotation an : object.getAnnotations()){
      if(an.annotationType().equals(anCls)){
        return true;
      }
    }
    return false;
  }

}
