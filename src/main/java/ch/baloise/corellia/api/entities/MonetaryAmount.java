package ch.baloise.corellia.api.entities;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class MonetaryAmount {

  @NotNull
  @Schema(description = "An amount, e.g. an insured sum or a deductible.")
  private BigDecimal amount;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
