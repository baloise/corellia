package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Person implements Serializable {

  private static final long serialVersionUID = 10;

  public enum Salutation {  Mr, Mrs }

  @NotNull
  private Salutation salutation;

  @NotNull
  @Size(min = LAST_NAME_MIN_SIZE, max = LAST_NAME_MAX_SIZE)
  private String lastName;

  @NotNull
  @Size(min = FIRST_NAME_MIN_SIZE, max = FIRST_NAME_MAX_SIZE)
  private String firstName;

  private LocalDate dateOfBirth;

  @Valid
  private PhoneNumber phoneNumber;

  @Size(min = EMAIL_MIN_SIZE, max = EMAIL_MAX_SIZE)
  @JsonPropertyDescription("A valid email address")
  private String emailAddress;

  @Size(min = LANGUAGE_SIZE, max = LANGUAGE_SIZE)
  @JsonProperty
  @JsonPropertyDescription("The language for correspondence with the customer. According to ISO 639-1 language codes, only the values 'de', 'fr', 'it' or 'en' are accepted.")
  private String language;

  @NotNull
  @Valid
  private Address address;

  public Person() {}

  public Salutation getSalutation() {
    return salutation;
  }

  public void setSalutation(Salutation salutation) {
    this.salutation = salutation;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
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
}