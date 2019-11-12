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

import static ch.baloise.corellia.api.constraints.SizeConstraint.LIST_MAX_SIZE;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Coverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("A code uniquely identifying a type of coverable")
  private Integer code;

  @Valid
  private Address riskLocation;

  @NotNull
  @Valid
  @Size(min = 1, max = LIST_MAX_SIZE)
  private List<Coverage> coverages;

  public Coverable() {
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Address getRiskLocation() {
    return riskLocation;
  }

  public void setRiskLocation(Address riskLocation) {
    this.riskLocation = riskLocation;
  }

  public List<Coverage> getCoverages() {
    return coverages;
  }

  public void setCoverages(List<Coverage> coverages) {
    this.coverages = coverages;
  }
}
