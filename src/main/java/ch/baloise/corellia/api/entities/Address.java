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

import static ch.baloise.corellia.api.constraints.SizeConstraint.CITY_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.HOUSE_NUMBER_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.STREET_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.ZIP_CODE_SIZE;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address implements Serializable {

  private static final long serialVersionUID = 10;

  @JsonPropertyDescription(
      "With access to the Baloise internal partner system it is also possible to deliver the internal reference to the corresponding address of the risk location.")
  @Valid
  private Integer riskLocationRef;

  @NotNull
  @Size(max = STREET_MAX_SIZE)
  private String street;

  @NotNull
  @Size(max = HOUSE_NUMBER_MAX_SIZE)
  private String houseNumber;

  @NotNull
  @Size(min = ZIP_CODE_SIZE, max = ZIP_CODE_SIZE)
  private String zipCode;

  @NotNull
  @Size(max = CITY_MAX_SIZE)
  private String city;

  public Address() {}

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
