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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Company implements Serializable {

  private static final long serialVersionUID = 10;

  @JsonFormat(shape = JsonFormat.Shape.OBJECT)
  public enum LegalForm {
    PRIVATPERSON("01"),
    EINZELUNTERNEHMEN("10"),
    GEWERBEBETRIEB("15"),
    EINFACHE_GESELLSCHAFT("20"),
    KOLLEKTIVGESELLSCHAFT("21"),
    KOMMANDITGESELLSCHAFT("22"),
    TREUHAENDERSCHAFT_TREUUNTERNEHMEN("23"),
    ERBENGEMEINSCHAFT("25"),
    EUROPAEISCHE_GESELLSCHAFT("29"),
    GENOSSENSCHAFT("30"),
    AKTIENGESELLSCHAFT("31"),
    KOMMANDIT_AKTIENGESELLSCHAFT("32"),
    GMBH("33"),
    STIFTUNG("34"),
    VEREIN("36"),
    ANSTALT_LI("38"),
    FORMLOSER_BERICHT("40"),
    ZWEIGNIEDERL_AUSLAEND_GESELLSCH("41"),
    INSTITUT_DES_OEFFENTL_RECHTS("55");

    private final String legalForm;

    LegalForm(final String legalForm) {
      this.legalForm = legalForm;
    }

    @JsonValue
    public String getLegalForm() {
      return legalForm;
    }

    @JsonCreator
    public static LegalForm forCode(String code) {
      return Arrays.stream(values()).filter(item -> item.getLegalForm().equals(code)).findFirst().orElse(null);
    }
  }

  @NotNull
  @Size(min = COMPANY_NAME_MIN_SIZE, max = COMPANY_NAME_MAX_SIZE)
  private String name;

  @Size(max = UID_NUMBER_MAX_SIZE)
  @JsonPropertyDescription("Identifies a company uniquely, example CHE-105.805.649")
  private String uidNumber;

  @Size(min = LEGAL_FORM_MIN_MAX_SIZE, max = LEGAL_FORM_MIN_MAX_SIZE)
  @JsonPropertyDescription("Identifies the legal form of the company by CrediReform codes. Has to be provided if UID is missing.")
  private LegalForm legalForm;

  @NotNull
  @JsonPropertyDescription("A contact is a person representing the company")
  private Person.Salutation contactSalutation;

  @NotNull
  @Size(min = LAST_NAME_MIN_SIZE, max = LAST_NAME_MAX_SIZE)
  @JsonPropertyDescription("A contact is a person representing the company")
  private String contactLastName;

  @NotNull
  @Size(min = FIRST_NAME_MIN_SIZE, max = FIRST_NAME_MAX_SIZE)
  @JsonPropertyDescription("A contact is a person representing the company")
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

  public LegalForm getLegalForm() {
    return legalForm;
  }

  public void setLegalForm(LegalForm legalForm) {
    this.legalForm = legalForm;
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
