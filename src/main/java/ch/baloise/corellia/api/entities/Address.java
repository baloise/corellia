package ch.baloise.corellia.api.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class Address implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 35)
  private String street;

  @NotNull
  @Size(max = 10)
  private String houseNumber;

  @NotNull
  @Size(max = 4)
  private String zipCode;

  @NotNull
  @Size(max = 30)
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
