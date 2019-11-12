package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import javax.validation.constraints.NotNull;

public class TermsOfService {

  @NotNull
  @JsonPropertyDescription("The type of service terms")
  private Integer type;

  @NotNull
  @JsonPropertyDescription("The publish year of the service terms")
  private Integer year;

  public TermsOfService() {
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}
