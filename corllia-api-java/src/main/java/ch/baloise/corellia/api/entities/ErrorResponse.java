package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public class ErrorResponse {

  @JsonPropertyDescription("information about the error")
  private String message;

  @JsonPropertyDescription("a list of validation errors")
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
