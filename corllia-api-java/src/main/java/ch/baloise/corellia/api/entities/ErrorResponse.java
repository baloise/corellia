package ch.baloise.corellia.api.entities;

import java.util.List;

public class ErrorResponse {
  private String message;
  private List<ValidationError> validationErrors;

  public ErrorResponse(String message) {
    this.message = message;
  }

  public ErrorResponse(String message, List<ValidationError> validationErrors) {
    this.message = message;
    this.validationErrors = validationErrors;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<ValidationError> getValidationErrors() {
    return validationErrors;
  }

  public void setValidationErrors(List<ValidationError> validationErrors) {
    this.validationErrors = validationErrors;
  }
}
