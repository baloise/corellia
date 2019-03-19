package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class Role implements Serializable {

  private static final long serialVersionUID = 10;

  public enum RoleType {
    Insuranceholder, Payer
  };

  @NotNull
  private RoleType role;

  @Valid
  @Schema(description = "If the owner of the role corresponds to a person, this property must be filled in. Only one of the properties person or company may be filled.")
  private Person person;

  @Valid
  @Schema(description = "If the owner of the role corresponds to a company, this property must be filled in. Only one of the properties person or company may be filled.")
  private Company company;

  public Role() {}

  public RoleType getRole() {
    return role;
  }

  public void setRole(RoleType role) {
    this.role = role;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
