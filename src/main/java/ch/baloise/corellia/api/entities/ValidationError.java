package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public class ValidationError {
  @JsonPropertyDescription("the path to the invalid value")
  private String path;

  @JsonPropertyDescription("a list of error causes")
  private List<ErrorCause> errorCauses;

  public enum ErrorCause {
    REQUIRED, SIZE, INVALID_VALUE
  }

  public List<ErrorCause> getErrorCauses() {
    return errorCauses;
  }

  public void setErrorCauses(List<ErrorCause> errorCauses) {
    this.errorCauses = errorCauses;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public String toString() {
    return "ValidationError{" +
      "path='" + path + '\'' +
      ", errorCauses=" + errorCauses +
      '}';
  }

}
