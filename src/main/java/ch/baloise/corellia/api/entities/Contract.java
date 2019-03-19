package ch.baloise.corellia.api.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contract implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Schema(description = "the day the contract was issued")
  private LocalDate creationDate;

  @NotNull
  @Schema(description = "start of contract which means start of insurance coverage")
  private LocalDate startDate;

  @NotNull
  @Schema(description = "end of contract which means end of insurance coverage")
  private LocalDate endDate;

  @NotNull
  @Size(max = 20)
  @Schema(description = "id given by SaaS provider")
  private String contractId;

  @NotNull
  @Schema(description = "the amount the customer pays excluding tax")
  private MonetaryAmount totalNetPrice;

  @NotNull
  @Valid
  @Size(min = 1, max = 99)
  @Schema(description = "all roles in the contract, e.g. insuranceHolder")
  private List<Role> roles;

  @NotNull
  @Valid
  private Product product;

  @NotNull
  @Valid
  @Schema(description = "the agent who induced the contract issuance, usually is eligible for receiving commission")
  private Agent agent;

  @NotNull
  @Valid
  @Schema(description = "information about how the customer wants (or has already) payed the premium")
  private Payment payment;

  @NotNull
  @Size(min = 1, max = 99)
  @Schema(description = "a contract is only complete with its corresponding documents. This is the contract issued by the SaaS provider and maybe some further documents like e.g. customer provided documents like e.g. receipts")
  private List<FileHandle> fileHandles;

  @NotNull
  @Size(min = 1, max = 99)
  @Schema(description = "type of contract conditions")
  private String conditionType;

  @NotNull
  @Size(min = 4, max = 4)
  @Schema(description = "when was the condition issued Format MMYY")
  private String conditionMonthYear;

  public Contract() {}

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

  public String getConditionType() {
    return conditionType;
  }

  public void setConditionType(String conditionType) {
    this.conditionType = conditionType;
  }

  public String getConditionMonthYear() {
    return conditionMonthYear;
  }

  public void setConditionMonthYear(String conditionMonthYear) {
    this.conditionMonthYear = conditionMonthYear;
  }
}
