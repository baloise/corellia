package ch.baloise.corellia.api.entities;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class PhoneNumber {

  @NotNull
  @Schema(description = "Country code, default is +41.", defaultValue = "+41")
  private String countryCode;

  @NotNull
  @Schema(description = "Phone number, without the leading zero.")
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
