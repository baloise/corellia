package ch.baloise.corellia.api.doc;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.models.OpenAPI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class to generate the OpenAPI specification, based on the JAX-RS annotated API codebase.
 * <br>
 * Upon execution, the file {@code docs/openapi.json} will be overwritten by a newly generated
 * file.
 * <br>
 * This uses SWAGGER.IO core and respects {@link com.fasterxml.jackson.annotation.JsonPropertyDescription} annotated
 * descriptions upon schemata generation.
 */
public class OpenApi3DocGenerator {

    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("docs/openapi.json")){
            // Required to get the @JsonPropertyDescription
            ModelConverters.getInstance().addConverter(new JsonPropertyDescriptionResolver(Json.mapper()));

            OpenAPI openAPI = new JaxrsOpenApiContextBuilder()
                    .buildContext(true)
                    .read();
            File docs = new File("docs");
            docs.mkdirs();
            fw.write(Json.pretty(openAPI));
            fw.flush();
        } catch (OpenApiConfigurationException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
