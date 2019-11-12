package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class Payment {

  @NotNull
  @JsonPropertyDescription("A code uniquely identifying the type of payment e.g. invoice or creditcard, Paypal etc.")
  private Integer code;

  @NotNull
  @JsonPropertyDescription("The recurring type code.")
  private Integer recurringType;

  @JsonPropertyDescription("The due date for the recurring type")
  private LocalDate dueDate;

  public Payment() {
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Integer getRecurringType() {
    return recurringType;
  }

  public void setRecurringType(Integer recurringType) {
    this.recurringType = recurringType;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }
}
