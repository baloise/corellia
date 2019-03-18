package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Coverage implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  @Size(max = 20)
  private String code;

  @NotNull
  private BigDecimal premium;

  @NotNull
  private Integer deductible;

  public Coverage() {}

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

  public BigDecimal getPremium() {
    return premium;
  }

  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }

  public Integer getDeductible() {
    return deductible;
  }

  public void setDeductible(Integer deductible) {
    this.deductible = deductible;
  }

}
