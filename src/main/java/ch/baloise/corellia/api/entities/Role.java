package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Role implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  // TODO: 15.03.2019 b021719 codify role
  private String role;

  @NotNull
  @Valid
  private Person person;

  @NotNull
  @Valid
  private Company company;

  public Role() {}

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
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
