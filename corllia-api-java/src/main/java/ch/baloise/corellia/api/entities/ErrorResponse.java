package ch.baloise.corellia.api.entities;

import java.util.List;

public class ErrorResponse {
  private String message;
  private List<ValidationError> errors;

  public ErrorResponse(String message) {
    this.message = message;
  }

  public ErrorResponse(String message, List<ValidationError> errors) {
    this.message = message;
    this.errors = errors;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<ValidationError> getErrors() {
    return errors;
  }

  public void setErrors(List<ValidationError> errors) {
    this.errors = errors;
  }
}
