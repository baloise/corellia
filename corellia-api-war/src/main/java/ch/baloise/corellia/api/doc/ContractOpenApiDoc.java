/*
 * Copyright 2018 Baloise Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.baloise.corellia.api.doc;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.Annotated;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;

import static io.swagger.v3.core.util.Json.prettyPrint;

/**
 * A sandbox class to try to get @JsonPropertyDescription to be used as schema-field description in
 * swagger (json) file.
 * Current approach:
 * Adding a custom ModelConverter, which (hierarchy-aware) reads the annotation (JsonPropertyDescription)
 * from the field (e.g. property) that is currently resolved.
 * For uknown reasons this currently only works for the ErrorResponse entity.
 * The resulting json is simply printed to the console for now.
 */
public class ContractOpenApiDoc {



    private static class CustomConverter implements ModelConverter {

        public CustomConverter() {
        }

        private AnnotatedType currentRootType;

        @Override
        public Schema resolve(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
            System.out.println("Processing: " + type.getType().getTypeName());
            if (chain.hasNext()) {
                if (type.getParent() == null) {
                    currentRootType = type;
                }
                Schema s = chain.next().resolve(type, context, chain);
                if (type.getCtxAnnotations() != null) {
                    for (Annotation a : type.getCtxAnnotations()) {
                        if (a.annotationType().equals(JsonPropertyDescription.class)) {
                            if (currentRootType.getType() instanceof Class) {
                                Class clazz = (Class) currentRootType.getType();
                                try {
                                    Field f = clazz.getDeclaredField(type.getPropertyName());
                                    JsonPropertyDescription desc = f.getAnnotation(JsonPropertyDescription.class);
//                                    if(s.getDescription() != null && s.getDescription().isEmpty()){
                                    s.description(desc.value());
                                    System.out.println("Added desc (" + desc.value() + ") to " + ((Class) currentRootType.getType()).getName() + "#" + type.getPropertyName());
//                                    }
                                } catch (NoSuchFieldException e) {
                                    // Ignore

                                }
                            }
                        }
                    }
                }
                return s;
            } else {
                Schema s = new Schema();
                s.name(type.getName());

                return s;
            }
        }
    }

    public static void main(String[] args) {
        try {
           /* JaxrsOpenApiContextBuilder builder = new JaxrsOpenApiContextBuilder();
            OpenApiContext context = builder.buildContext(true);
            context.setOpenApiScanner(new GenericOpenApiScanner());
            context.init();
            OpenAPI openAPI = context.read();*/

            //ModelConverters.getInstance().addConverter(new CustomConverter());
            ModelConverters.getInstance().addConverter(new JsonPropertyDescriptionResolver(Json.mapper()));

            OpenAPI openAPI = new JaxrsOpenApiContextBuilder()
                    .buildContext(true)
                    .read();
            System.out.println("---");
            prettyPrint(openAPI);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
