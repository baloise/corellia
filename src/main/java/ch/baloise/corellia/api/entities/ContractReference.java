package ch.baloise.corellia.api.entities;

import javax.validation.constraints.Size;

public class ContractReference {

  @Size(min = 1, max = 30)
  private String reference;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}
