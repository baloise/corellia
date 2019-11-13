package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import javax.validation.constraints.NotNull;

public class TermsOfService {

  @NotNull
  @JsonPropertyDescription("The type of service terms")
  private Integer type;

  @NotNull
  @JsonPropertyDescription("The edition of the service terms")
  private Integer edition;

  public TermsOfService() {
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getEdition() {
    return edition;
  }

  public void setEdition(Integer edition) {
    this.edition = edition;
  }
}
