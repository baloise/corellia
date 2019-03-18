package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Property extends AbstractCoverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  private Date dateOfPurchase;

  @NotNull
  private Date endOfManufacturersWarranty;

  @NotNull
  @Size(max = 100)
  private String serialNumber;

  @NotNull
  @Size(max = 100)
  private String brand;

  @NotNull
  @Size(max = 100)
  private String model;

  @NotNull
  @Size(max = 100)
  private String invoiceNumber;

  public Property() {}

  public Date getDateOfPurchase() {
    return dateOfPurchase;
  }

  public void setDateOfPurchase(Date dateOfPurchase) {
    this.dateOfPurchase = dateOfPurchase;
  }

  public Date getEndOfManufacturersWarranty() {
    return endOfManufacturersWarranty;
  }

  public void setEndOfManufacturersWarranty(Date endOfManufacturersWarranty) {
    this.endOfManufacturersWarranty = endOfManufacturersWarranty;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

}
