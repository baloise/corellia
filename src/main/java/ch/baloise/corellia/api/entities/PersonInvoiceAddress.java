package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonInvoiceAddress implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  // TODO: 15.03.2019 b021719 introduce a salutation code
  private String salutation;

  @NotNull
  @Size(max = 35)
  private String name;

  @NotNull
  @Size(max = 35)
  private String firstName;

  @NotNull
  @Valid
  private Address address;

  public PersonInvoiceAddress() {}

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
