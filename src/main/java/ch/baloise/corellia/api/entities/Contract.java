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

import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_FILE_HANDLES_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_FILE_HANDLES_MIN_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.LIST_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.MONTH_YEAR_SIZE;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contract implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("The day the contract was issued")
  private LocalDate creationDate;

  @NotNull
  @JsonPropertyDescription("Start of contract which means start of insurance coverage")
  private LocalDate startDate;

  @NotNull
  @JsonPropertyDescription("End of contract which means end of insurance coverage")
  private LocalDate endDate;

  @NotNull
  @JsonPropertyDescription("The amount the customer pays excluding tax")
  private MonetaryAmount totalNetPrice;

  @NotNull
  @Valid
  @Size(min = 1, max = LIST_MAX_SIZE)
  @JsonPropertyDescription("All roles in the contract, e.g. insuranceHolder")
  private List<Role> roles;

  @NotNull
  @Valid
  private Product product;

  @Valid
  @JsonPropertyDescription("The agent who induced the contract issuance, usually is eligible for receiving commission")
  private Agent agent;

  @NotNull
  @Size(min = CONTRACT_FILE_HANDLES_MIN_SIZE, max = CONTRACT_FILE_HANDLES_MAX_SIZE)
  @JsonPropertyDescription("A contract is only complete with its corresponding documents. This is the contract issued by the SaaS provider and maybe some further documents like e.g. customer provided documents like e.g. receipts. At least one contract document is required")
  private List<FileHandle> fileHandles;

  @NotNull
  @Size(min = MONTH_YEAR_SIZE, max = MONTH_YEAR_SIZE)
  @JsonPropertyDescription("When was the condition issued? Format MMYY")
  private String conditionMonthYear;

  @NotNull
  @JsonPropertyDescription("The tax stamp code for this contract")
  private Integer stampTaxCode;

  @NotNull
  @Valid
  private TermsOfService termsOfService;

  @NotNull
  @Valid
  private Action action;

  @NotNull
  @Valid
  private Identifier identifier;

  @NotNull
  @Valid
  private Payment payment;

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

  public Integer getStampTaxCode() {
    return stampTaxCode;
  }

  public void setStampTaxCode(Integer stampTaxCode) {
    this.stampTaxCode = stampTaxCode;
  }

  public TermsOfService getTermsOfService() {
    return termsOfService;
  }

  public void setTermsOfService(TermsOfService termsOfService) {
    this.termsOfService = termsOfService;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public Identifier getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Identifier identifier) {
    this.identifier = identifier;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
