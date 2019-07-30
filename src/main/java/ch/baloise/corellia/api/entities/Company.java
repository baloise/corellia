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
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;

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
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "01")
        }
    )
    PRIVATPERSON("01"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    EINZELUNTERNEHMEN("10"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    GEWERBEBETRIEB("15"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    EINFACHE_GESELLSCHAFT("20"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    KOLLEKTIVGESELLSCHAFT("21"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    KOMMANDITGESELLSCHAFT("22"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    TREUHAENDERSCHAFT_TREUUNTERNEHMEN("23"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    ERBENGEMEINSCHAFT("25"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    EUROPAEISCHE_GESELLSCHAFT("29"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    GENOSSENSCHAFT("30"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    AKTIENGESELLSCHAFT("31"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    KOMMANDIT_AKTIENGESELLSCHAFT("32"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    GMBH("33"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    STIFTUNG("34"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    VEREIN("36"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    ANSTALT_LI("38"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    FORMLOSER_BERICHT("40"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
    ZWEIGNIEDERL_AUSLAEND_GESELLSCH("41"),
    @Extension(
        name = "properties",
        properties = {
            @ExtensionProperty(name = "value", value = "10")
        }
    )
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
  @JsonPropertyDescription("identifies a company uniquely, example CHE-105.805.649")
  private String uidNumber;

  @Size(min = LEGAL_FORM_MIN_MAX_SIZE, max = LEGAL_FORM_MIN_MAX_SIZE)
  @JsonPropertyDescription("identifies the legal form of the company by CrediReform codes. Has to be provided if UID is missing.")
  private LegalForm legalForm;

  @NotNull
  @JsonPropertyDescription("a contact is a person representing the company")
  private Person.Salutation contactSalutation;

  @NotNull
  @Size(min = LAST_NAME_MIN_SIZE, max = LAST_NAME_MAX_SIZE)
  @JsonPropertyDescription("a contact is a person representing the company")
  private String contactLastName;

  @NotNull
  @Size(min = FIRST_NAME_MIN_SIZE, max = FIRST_NAME_MAX_SIZE)
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
