package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  private Integer code;

  private LocalDate pricingYear;

  @NotNull
  @Valid
  @Size(min = 0, max = 99)
  private List<Coverable> coverables;

  public Product() {}

  public LocalDate getPricingYear() {
    return pricingYear;
  }

  public void setPricingYear(LocalDate pricingYear) {
    this.pricingYear = pricingYear;
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
