package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Cancellation implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Valid
  private Identifier identifier;

  @NotNull
  @JsonPropertyDescription("effecitve date of cancellation")
  private LocalDate effectiveDate;

  @NotNull
  @JsonPropertyDescription("A code uniquely identifying the cancellation reason")
  private Integer reasonCode;

  public Identifier getIdentifier() { return identifier; }

  public void setIdentifier(Identifier identifier) { this.identifier = identifier; }

  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(LocalDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Integer getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(Integer reasonCode) {
    this.reasonCode = reasonCode;
  }
}
