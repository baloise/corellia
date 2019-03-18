package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Payment implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  @Size(max = 20)
  private String code;

  @Size(max = 20)
  private String discountCode;

  @Valid
  private CompanyInvoiceAddress companyInvoiceAddress;

  @Valid
  private PersonInvoiceAddress personInvoiceAddress;

  public Payment() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDiscountCode() {
    return discountCode;
  }

  public void setDiscountCode(String discountCode) {
    this.discountCode = discountCode;
  }

  public CompanyInvoiceAddress getCompanyInvoiceAddress() {
    return companyInvoiceAddress;
  }

  public void setCompanyInvoiceAddress(CompanyInvoiceAddress companyInvoiceAddress) {
    this.companyInvoiceAddress = companyInvoiceAddress;
  }

  public PersonInvoiceAddress getPersonInvoiceAddress() {
    return personInvoiceAddress;
  }

  public void setPersonInvoiceAddress(PersonInvoiceAddress personInvoiceAddress) {
    this.personInvoiceAddress = personInvoiceAddress;
  }

}
