package ch.baloise.corellia.api.entities;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Movement extends AbstractCoverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  private Date movingDate;

  @NotNull
  @Valid
  private Address from;

  @NotNull
  @Valid
  private Address to;

  public Movement() {
  }

  public Date getMovingDate() {
    return movingDate;
  }

  public void setMovingDate(Date movingDate) {
    this.movingDate = movingDate;
  }

  public Address getFrom() {
    return from;
  }

  public void setFrom(Address from) {
    this.from = from;
  }

  public Address getTo() {
    return to;
  }

  public void setTo(Address to) {
    this.to = to;
  }
}
