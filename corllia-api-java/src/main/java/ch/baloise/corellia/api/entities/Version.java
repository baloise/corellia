package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Version {
  @NotNull
  @JsonPropertyDescription("version identifier of the current API definition")
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Version{" + "value='" + value + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Version version = (Version)o;
    return Objects.equals(value, version.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
