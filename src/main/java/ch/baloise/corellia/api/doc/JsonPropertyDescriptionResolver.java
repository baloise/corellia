package ch.baloise.corellia.api.doc;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.Annotated;
import io.swagger.v3.core.jackson.ModelResolver;

import java.lang.annotation.Annotation;


/**
 * Custom ModelResolver which resolves descriptions given by
 */
public class JsonPropertyDescriptionResolver extends ModelResolver {
    public JsonPropertyDescriptionResolver(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    protected String resolveDescription(Annotated a, Annotation[] annotations, io.swagger.v3.oas.annotations.media.Schema schema) {
        if (annotations != null) {
            for (Annotation ann : annotations) {
                if (ann instanceof JsonPropertyDescription) {
                    JsonPropertyDescription spd = (JsonPropertyDescription) ann;
                    return spd.value();
                }
            }
        }
        return super.resolveDescription(a, annotations, schema);
    }
}
