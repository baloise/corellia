package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  @JsonPropertyDescription("a code uniquely identifying the product")
  private Integer code;

  @JsonPropertyDescription("The month/year in which the pricing for the contract was set. Format MMYY")
  private String pricingMonthYear;

  @NotNull
  @Valid
  @Size(min = 0, max = 99)
  private List<Coverable> coverables;

  public Product() {}

  public String getPricingMonthYear() {
    return pricingMonthYear;
  }

  public void setPricingMonthYear(String pricingMonthYear) {
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
