package ch.baloise.corellia.api;

import ch.baloise.corellia.api.doc.JsonPropertyDescriptionResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.OpenAPI;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/insurance")
public class ContractApplication extends Application {

  ObjectMapper mapper = new ObjectMapper() //
      .registerModule(new ParameterNamesModule()) //
      .registerModule(new Jdk8Module()) //
      .registerModule(new JavaTimeModule()); // new module, NOT JSR310Module

  {
    ModelConverters.getInstance().addConverter(new JsonPropertyDescriptionResolver(Json.mapper()));
  }

}
