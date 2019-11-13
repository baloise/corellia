package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import javax.validation.constraints.NotNull;

public class Identifier {

  @NotNull
  @JsonPropertyDescription("Id depending on the type.")
  private String id;

  @NotNull
  @JsonPropertyDescription("The type of the id. EXT or INT.")
  private String type;

  public Identifier() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
