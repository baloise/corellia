/*
 * Copyright 2018 Baloise Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.baloise.corellia.api.entities;

import static ch.baloise.corellia.api.constraints.SizeConstraint.EMAIL_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.EMAIL_MIN_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.FIRST_NAME_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.FIRST_NAME_MIN_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.LANGUAGE_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.LAST_NAME_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.LAST_NAME_MIN_SIZE;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.time.LocalDate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public class Person implements Serializable {

  private static final long serialVersionUID = 10;

  public enum Salutation {  Mr, Mrs }

  @JsonPropertyDescription("Required when partnerNr not set!")
  private Salutation salutation;

  @JsonPropertyDescription("Required when partnerNr not set!")
  @Size(min = LAST_NAME_MIN_SIZE, max = LAST_NAME_MAX_SIZE)
  private String lastName;

  @JsonPropertyDescription("Required when partnerNr not set!")
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
  @JsonPropertyDescription("The language for correspondence with the customer. According to ISO 639-1 language codes, only the values 'de', 'fr', 'it' or 'en' are accepted. Required when partnerNr not set!")
  private String language;

  @JsonPropertyDescription("Required when partnerNr not set!")
  @Valid
  private Address address;

  @JsonPropertyDescription("The PartnerNr of the partner.")
  private Integer partnerNr;

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

  public Integer getPartnerNr() {
    return partnerNr;
  }

  public void setPartnerNr(Integer partnerNr) {
    this.partnerNr = partnerNr;
  }
}
