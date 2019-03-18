package ch.baloise.corellia.api.entities;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CompanyInvoiceAddress implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 70)
  private String name;

  @NotNull
  @Valid
  private Address address;

  public CompanyInvoiceAddress() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
