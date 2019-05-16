package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Size;

import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_REFERENCE_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_REFERENCE_MIN_SIZE;

public class ContractReference {

  @Size(min = CONTRACT_REFERENCE_MIN_SIZE, max = CONTRACT_REFERENCE_MAX_SIZE)
  @JsonPropertyDescription("under this reference the contract is stored at Baloise")
  private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}
