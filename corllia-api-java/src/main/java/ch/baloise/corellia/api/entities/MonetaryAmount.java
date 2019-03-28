package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MonetaryAmount {

  @NotNull
  @JsonPropertyDescription("An amount with two decimal digit like an insured sum or a deductible (e.g. 100,22).")
  private BigDecimal amount;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
