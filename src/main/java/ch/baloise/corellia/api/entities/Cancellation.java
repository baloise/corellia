package ch.baloise.corellia.api.entities;

import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_ID_MAX_SIZE;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cancellation implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = CONTRACT_ID_MAX_SIZE)
  @JsonPropertyDescription(
      "Id given by SaaS provider. Identifies the contract which should be cancelled")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("effecitve date of cancellation")
  private LocalDate effectiveDate;

  @NotNull
  @JsonPropertyDescription("A code uniquely identifying the cancellation reason")
  private Integer reasonCode;

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

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
