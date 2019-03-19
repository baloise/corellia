package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class Payment implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  private Integer code;

  @Valid
  @Schema(description = "If the payment was done by a company, this property must be filled. Only one of the properties person or company may be filled.")
  private Company company;

  @Valid
  @Schema(description = "If the payment was done by a person, this property must be filled. Only one of the properties person or company may be filled.")
  private Person person;

  public Payment() {}

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
