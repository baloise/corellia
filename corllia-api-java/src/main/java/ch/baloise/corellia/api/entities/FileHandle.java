package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;

public class FileHandle {

  @NotNull
  @JsonPropertyDescription("Reference to an uploaded file. This can be e.g. a PDF or a picture (e.g. JPG) of a contract or a purchase receipt.")
  private String handle;

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

}
