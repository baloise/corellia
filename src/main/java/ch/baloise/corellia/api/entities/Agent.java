package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Agent implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = AGENT_NUMBER_MAX_SIZE)
  @JsonPropertyDescription("Identification of an Agent")
  private String agentNumber;

  @NotNull
  @Size(min = EMAIL_MIN_SIZE, max = EMAIL_MAX_SIZE)
  @JsonPropertyDescription("A valid email adress")
  private String email;

  public Agent() {
  }

  public String getAgentNumber() {
    return agentNumber;
  }

  public void setAgentNumber(String agentNumber) {
    this.agentNumber = agentNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
