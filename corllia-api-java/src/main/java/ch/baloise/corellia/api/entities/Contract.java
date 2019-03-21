package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
  @Size(max = 20)
  @JsonPropertyDescription("id given by SaaS provider")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("the amount the customer pays excluding tax")
  private ch.baloise.corellia.api.entities.MonetaryAmount totalNetPrice;

  @NotNull
  @Valid
  @Size(min = 1, max = 99)
  @JsonPropertyDescription("all roles in the contract, e.g. insuranceHolder")
  private List<Role> roles;

  @NotNull
  @Valid
  private ch.baloise.corellia.api.entities.Product product;

  @Valid
  @JsonPropertyDescription("the agent who induced the contract issuance, usually is eligible for receiving commission")
  private Agent agent;

  @NotNull
  @Valid
  @JsonPropertyDescription("information about how the customer wants (or has already) payed the premium")
  private ch.baloise.corellia.api.entities.Payment payment;

  @NotNull
  @Size(min = 1, max = 99)
  @JsonPropertyDescription("a contract is only complete with its corresponding documents. This is the contract issued by the SaaS provider and maybe some further documents like e.g. customer provided documents like e.g. receipts")
  private List<ch.baloise.corellia.api.entities.FileHandle> fileHandles;

  @NotNull
  @Size(min = 4, max = 4)
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

  public ch.baloise.corellia.api.entities.MonetaryAmount getTotalNetPrice() {
    return totalNetPrice;
  }

  public void setTotalNetPrice(ch.baloise.corellia.api.entities.MonetaryAmount totalNetPrice) {
    this.totalNetPrice = totalNetPrice;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public ch.baloise.corellia.api.entities.Product getProduct() {
    return product;
  }

  public void setProduct(ch.baloise.corellia.api.entities.Product product) {
    this.product = product;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public ch.baloise.corellia.api.entities.Payment getPayment() {
    return payment;
  }

  public void setPayment(ch.baloise.corellia.api.entities.Payment payment) {
    this.payment = payment;
  }

  public List<ch.baloise.corellia.api.entities.FileHandle> getFileHandles() {
    return fileHandles;
  }

  public void setFileHandles(List<ch.baloise.corellia.api.entities.FileHandle> fileHandles) {
    this.fileHandles = fileHandles;
  }

  public String getConditionMonthYear() {
    return conditionMonthYear;
  }

  public void setConditionMonthYear(String conditionMonthYear) {
    this.conditionMonthYear = conditionMonthYear;
  }
}
