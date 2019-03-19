package ch.baloise.corellia.api.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Size;

public class ContractReference {

  @Size(min = 1, max = 30)
  @Schema(description = "under this reference the contract is stored at Baloise")
  private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}
