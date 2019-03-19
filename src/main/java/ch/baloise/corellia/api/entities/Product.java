package ch.baloise.corellia.api.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  private Integer code;

  @Schema(description = "The month/year in which the pricing for the contract was set. Format MMYY")
  private LocalDate pricingMonthYear;

  @NotNull
  @Valid
  @Size(min = 0, max = 99)
  private List<Coverable> coverables;

  public Product() {}

  public LocalDate getPricingMonthYear() {
    return pricingMonthYear;
  }

  public void setPricingMonthYear(LocalDate pricingMonthYear) {
    this.pricingMonthYear = pricingMonthYear;
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
