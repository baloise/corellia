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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

import static ch.baloise.corellia.api.constraints.SizeConstraint.LIST_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.MONTH_YEAR_SIZE;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("a code uniquely identifying the product")
  private Integer code;

  @NotNull
  @Size(min = MONTH_YEAR_SIZE, max = MONTH_YEAR_SIZE)
  @JsonPropertyDescription("The month/year in which the pricing for the contract was set. Format MMYY")
  private String pricingMonthYear;

  @NotNull
  @Valid
  @Size(min = 0, max = LIST_MAX_SIZE)
  private List<Coverable> coverables;

  public Product() {}

  public String getPricingMonthYear() {
    return pricingMonthYear;
  }

  public void setPricingMonthYear(String pricingMonthYear) {
    this.pricingMonthYear = pricingMonthYear;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public List<Coverable> getCoverables() {
    return coverables;
  }

  public void setCoverables(List<Coverable> coverables) {
    this.coverables = coverables;
  }
}
