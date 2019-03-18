package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Company implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(min = 3, max = 70)
  private String name;

  @NotNull
  @Size(max = 20)
  // TODO: 15.03.2019 b021719 Code gemäss Coderechtsform mit Kasko vereinbaren
  private String legalForm;

  @NotNull
  @Size(max = 15)
  @JsonPropertyDescription("example CHE-105.805.649")
  private String uidNumber;

  @NotNull
  @Valid
  private Address address;


  public Company() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLegalForm() {
    return legalForm;
  }

  public void setLegalForm(String legalForm) {
    this.legalForm = legalForm;
  }

  public String getUidNumber() {
    return uidNumber;
  }

  public void setUidNumber(String uidNumber) {
    this.uidNumber = uidNumber;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
