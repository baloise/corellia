package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contract implements Serializable {

  private static final long serialVersionUID = 10;

  // TODO: 18.03.2019 b021719 Abgaben aufnehmen FL vs. CH

  @NotNull
  private Date startDate;

  @NotNull
  private Date endDate;

  @NotNull
  private Date policyIssueDate;

  @NotNull
  @Size(max = 20)
  private String policyId;

  @NotNull
  private BigDecimal totalNetPrice;

  @NotNull
  private BigDecimal stampTax;

  @NotNull
  @Valid
  @Size(min = 1, max = 2)
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
  @Size(max = 20)
  private String distributor;

  @NotNull
  @Size(min = 1, max = 99)
  private List<String> documentHandles;

  @NotNull
  @Size(max = 20)
  // TODO: 15.03.2019 b021719 use code for term representation? 
  private String term;

  public Contract() {}

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Date getPolicyIssueDate() {
    return policyIssueDate;
  }

  public void setPolicyIssueDate(Date policyIssueDate) {
    this.policyIssueDate = policyIssueDate;
  }

  public String getPolicyId() {
    return policyId;
  }

  public void setPolicyId(String policyId) {
    this.policyId = policyId;
  }

  public BigDecimal getTotalNetPrice() {
    return totalNetPrice;
  }

  public void setTotalNetPrice(BigDecimal totalNetPrice) {
    this.totalNetPrice = totalNetPrice;
  }

  public BigDecimal getStampTax() {
    return stampTax;
  }

  public void setStampTax(BigDecimal stampTax) {
    this.stampTax = stampTax;
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

  public String getDistributor() {
    return distributor;
  }

  public void setDistributor(String distributor) {
    this.distributor = distributor;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public List<String> getDocumentHandles() {
    return documentHandles;
  }

  public void setDocumentHandles(List<String> documentHandles) {
    this.documentHandles = documentHandles;
  }

}
