package ch.baloise.corellia.api.doc;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.models.OpenAPI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class OpenApiDocGenerator {

    public static void main(String[] args) {
        try {
            ModelConverters.getInstance().addConverter(new JsonPropertyDescriptionResolver(Json.mapper()));

            OpenAPI openAPI = new JaxrsOpenApiContextBuilder()
                    .buildContext(true)
                    .read();
            File docs = new File("docs");
            docs.delete();
            docs.mkdirs();
            FileWriter fw = new FileWriter("docs/openapi.json");
            fw.write(Json.pretty(openAPI));
            fw.flush();
            fw.close();
        } catch (OpenApiConfigurationException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
