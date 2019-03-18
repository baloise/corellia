package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contract implements Serializable {

  private static final long serialVersionUID = 10;

  // TODO: 18.03.2019 b021719 Abgaben aufnehmen FL vs. CH

  @NotNull
  private LocalDate startDate;

  @NotNull
  private LocalDate endDate;

  @NotNull
  @Size(max = 20)
  private String contractId;

  @NotNull
  private MonetaryAmount totalNetPrice;

  @NotNull
  @Valid
  @Size(min = 1, max = 99)
  private List<Role> roles;

  @NotNull
  @Valid
  private Product product;

  @NotNull
  @Valid
  private Agent agent;

  @NotNull
  @Valid
  private Payment payment;

  @NotNull
  @Size(min = 1, max = 99)
  private List<FileHandle> fileHandles;

  public Contract() {}

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
}
