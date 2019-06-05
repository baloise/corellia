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

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static ch.baloise.corellia.api.constraints.SizeConstraint.PHONE_NUMBER_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.PHONE_NUMBER_MIN_SIZE;

public class PhoneNumber {

  @JsonPropertyDescription("Country code, default is +41.")
  private String countryCode;

  @NotNull
  @Size(min = PHONE_NUMBER_MIN_SIZE, max = PHONE_NUMBER_MAX_SIZE)
  @JsonPropertyDescription("Phone number, without the leading zero.")
  private String phoneNumber;

  public PhoneNumber() {
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
