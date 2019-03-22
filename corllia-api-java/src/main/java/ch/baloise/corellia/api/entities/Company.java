package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Company implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(min = 3, max = 70)
  private String name;

  @Size(max = 15)
  @JsonPropertyDescription("identifies a company uniquely, example CHE-105.805.649")
  private String uidNumber;

  @NotNull
  @JsonPropertyDescription("a contact is a person representing the company")
  private Person.Salutation contactSalutation;

  @NotNull
  @Size(min = 2, max = 35)
  @JsonPropertyDescription("a contact is a person representing the company")
  private String contactLastName;

  @NotNull
  @Size(min = 2, max = 35)
  @JsonPropertyDescription("a contact is a person representing the company")
  private String contactFirstName;

  @NotNull
  @Valid
  private Address address;

  public Company() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUidNumber() {
    return uidNumber;
  }

  public void setUidNumber(String uidNumber) {
    this.uidNumber = uidNumber;
  }

  public ch.baloise.corellia.api.entities.Person.Salutation getContactSalutation() {
    return contactSalutation;
  }

  public void setContactSalutation(ch.baloise.corellia.api.entities.Person.Salutation contactSalutation) {
    this.contactSalutation = contactSalutation;
  }

  public String getContactLastName() {
    return contactLastName;
  }

  public void setContactLastName(String contactLastName) {
    this.contactLastName = contactLastName;
  }

  public String getContactFirstName() {
    return contactFirstName;
  }

  public void setContactFirstName(String contactFirstName) {
    this.contactFirstName = contactFirstName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}