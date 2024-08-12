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

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public class Coverage implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("A code uniquely identifying a type of coverage")
  private Integer code;

  @NotNull
  private MonetaryAmount premium;

  private MonetaryAmount deductible;

  @NotNull
  private MonetaryAmount sumInsured;

  private Integer measurandType;

  private MonetaryAmount measurandValue;

  private Integer discountType;

  private MonetaryAmount discountValue;

  private Integer extraChargeType;

  private MonetaryAmount extraChargeValue;

  public Coverage() {
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public MonetaryAmount getPremium() {
    return premium;
  }

  public void setPremium(MonetaryAmount premium) {
    this.premium = premium;
  }

  public MonetaryAmount getDeductible() {
    return deductible;
  }

  public void setDeductible(MonetaryAmount deductible) {
    this.deductible = deductible;
  }

  public MonetaryAmount getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(MonetaryAmount sumInsured) {
    this.sumInsured = sumInsured;
  }

  public Integer getMeasurandType() {
    return measurandType;
  }

  public void setMeasurandType(Integer measurandType) {
    this.measurandType = measurandType;
  }

  public MonetaryAmount getMeasurandValue() {
    return measurandValue;
  }

  public void setMeasurandValue(MonetaryAmount measurandValue) {
    this.measurandValue = measurandValue;
  }

  public Integer getDiscountType() {
    return discountType;
  }

  public void setDiscountType(Integer discountType) {
    this.discountType = discountType;
  }

  public MonetaryAmount getDiscountValue() {
    return discountValue;
  }

  public void setDiscountValue(MonetaryAmount discountValue) {
    this.discountValue = discountValue;
  }

  public Integer getExtraChargeType() {
    return extraChargeType;
  }

  public void setExtraChargeType(Integer extraChargeType) {
    this.extraChargeType = extraChargeType;
  }

  public MonetaryAmount getExtraChargeValue() {
    return extraChargeValue;
  }

  public void setExtraChargeValue(MonetaryAmount extraChargeValue) {
    this.extraChargeValue = extraChargeValue;
  }
}
