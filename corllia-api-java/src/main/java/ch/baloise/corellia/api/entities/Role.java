package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonClassDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonClassDescription("At least and at most one one of the properties person or company must provided")
public class Role implements Serializable {

  private static final long serialVersionUID = 10;

  public enum RoleType {insuranceholder, payer}

  @NotNull
  private RoleType role;

  @Valid
  private Person person;

  @Valid
  private Company company;

  public Role() {
  }

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
