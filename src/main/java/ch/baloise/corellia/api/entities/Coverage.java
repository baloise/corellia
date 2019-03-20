package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Coverage implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @JsonPropertyDescription("a code uniquely identifying a type of coverage")
  private Integer code;

  @NotNull
  private MonetaryAmount premium;

  private MonetaryAmount deductible;

  @NotNull
  private MonetaryAmount sumInsured;

  public Coverage() {
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public MonetaryAmount getPremium() {
    return premium;
  }

  public void setPremium(MonetaryAmount premium) {
    this.premium = premium;
  }

  public MonetaryAmount getDeductible() {
    return deductible;
  }

  public void setDeductible(MonetaryAmount deductible) {
    this.deductible = deductible;
  }

  public MonetaryAmount getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(MonetaryAmount sumInsured) {
    this.sumInsured = sumInsured;
  }
}
