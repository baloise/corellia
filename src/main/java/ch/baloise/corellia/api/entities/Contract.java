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
import java.time.LocalDate;
import java.util.List;

import static ch.baloise.corellia.api.constraints.SizeConstraint.*;

public class Contract implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("the day the contract was issued")
  private LocalDate creationDate;

  @NotNull
  @JsonPropertyDescription("start of contract which means start of insurance coverage")
  private LocalDate startDate;

  @NotNull
  @JsonPropertyDescription("end of contract which means end of insurance coverage")
  private LocalDate endDate;

  @NotNull
  @Size(max = CONTRACT_ID_MAX_SIZE)
  @JsonPropertyDescription("id given by SaaS provider")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("the amount the customer pays excluding tax")
  private MonetaryAmount totalNetPrice;

  @NotNull
  @Valid
  @Size(min = 1, max = LIST_MAX_SIZE)
  @JsonPropertyDescription("all roles in the contract, e.g. insuranceHolder")
  private List<Role> roles;

  @NotNull
  @Valid
  private Product product;

  @Valid
  @JsonPropertyDescription("the agent who induced the contract issuance, usually is eligible for receiving commission")
  private Agent agent;

  @NotNull
  @Valid
  @JsonPropertyDescription("information about how the customer wants (or has already) payed the premium")
  private Payment payment;

  @NotNull
  @Size(min = 1, max = LIST_MAX_SIZE)
  @JsonPropertyDescription("a contract is only complete with its corresponding documents. This is the contract issued by the SaaS provider and maybe some further documents like e.g. customer provided documents like e.g. receipts")
  private List<FileHandle> fileHandles;

  @NotNull
  @Size(min = MONTH_YEAR_SIZE, max = MONTH_YEAR_SIZE)
  @JsonPropertyDescription("when was the condition issued? Format MMYY")
  private String conditionMonthYear;

  public Contract() {
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  public MonetaryAmount getTotalNetPrice() {
    return totalNetPrice;
  }

  public void setTotalNetPrice(MonetaryAmount totalNetPrice) {
    this.totalNetPrice = totalNetPrice;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public List<FileHandle> getFileHandles() {
    return fileHandles;
  }

  public void setFileHandles(List<FileHandle> fileHandles) {
    this.fileHandles = fileHandles;
  }

  public String getConditionMonthYear() {
    return conditionMonthYear;
  }

  public void setConditionMonthYear(String conditionMonthYear) {
    this.conditionMonthYear = conditionMonthYear;
  }
}
