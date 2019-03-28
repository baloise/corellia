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
