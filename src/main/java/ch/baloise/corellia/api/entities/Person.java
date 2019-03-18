package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.info.Info;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  // TODO: 15.03.2019 b021719 code?
  private String salutation;

  @NotNull
  @Size(min = 2, max = 35)
  private String name;

  @NotNull
  @Size(min= 2, max = 35)
  private String firstName;

  @NotNull
  private Date dateOfBirth;

  @NotNull
  @Size(min=2, max = 2)
  @JsonPropertyDescription("according to ISO_3166-1_alpha-2, e.g. CH, DE, GB")
  private String citizenship;

  @NotNull
  @Size(max = 30)
  private String phone;

  @NotNull
  @Size(max = 70)
  // TODO: 15.03.2019 b021719 provide regexp for validation? 
  private String emailAddress;

  @NotNull
  @Size(min= 2, max = 2)
  @JsonPropertyDescription("the language for correspondence with the customer, according to ISO 639-1 language code, only DE, FR, IT, or EN are accepted")
  private String language;

  @NotNull
  @Valid
  private Address address;

  @Size(max = 20)
  @JsonPropertyDescription("if a Person is a member in another organization which is relevant in a contract context - e.g. a TCS-Membership")
  private String membershipId;

  public Person() {}

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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCitizenship() {
    return citizenship;
  }

  public void setCitizenship(String citizenship) {
    this.citizenship = citizenship;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getMembershipId() {
    return membershipId;
  }

  public void setMembershipId(String membershipId) {
    this.membershipId = membershipId;
  }
}
