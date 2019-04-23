package ch.baloise.corellia.api.entities;

import java.util.List;

public class ValidationError {
  private String path;
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

}
