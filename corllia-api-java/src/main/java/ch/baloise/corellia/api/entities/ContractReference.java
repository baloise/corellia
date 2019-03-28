package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Size;

public class ContractReference {

  @Size(min = 1, max = 30)
  @JsonPropertyDescription("under this reference the contract is stored at Baloise")
  private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}
