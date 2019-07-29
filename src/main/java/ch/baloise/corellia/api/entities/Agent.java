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
import java.io.Serializable;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Agent implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = AGENT_NUMBER_MAX_SIZE)
  @JsonPropertyDescription("Identification of an Agent")
  private String agentNumber;

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
