package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public class Action {

  @NotNull
  @JsonPropertyDescription("The type of the action")
  private Integer type;

  @NotNull
  @JsonPropertyDescription("The reason for this type")
  private Integer reason;

  @JsonPropertyDescription("The date when this change should be effective")
  private LocalDate effective;

  public Action() {
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getReason() {
    return reason;
  }

  public void setReason(Integer reason) {
    this.reason = reason;
  }

  public LocalDate getEffective() {
    return effective;
  }

  public void setEffective(LocalDate effective) {
    this.effective = effective;
  }
}
