package ch.baloise.corellia.api.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Address implements Serializable {

  private static final long serialVersionUID = 10;

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

  public Address() {
  }

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
