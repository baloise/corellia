package ch.baloise.corellia.api.entities;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MonetaryAmount {

  @NotNull
  private BigDecimal amount;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
