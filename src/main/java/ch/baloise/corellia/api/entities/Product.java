package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  @Size(max = 20)
  private String code;

  @NotNull
  @Valid
  @Size(min = 0, max = 100)
  private List<? extends AbstractCoverable> coverables;

  public Product() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<? extends AbstractCoverable> getCoverables() {
    return coverables;
  }

  public void setCoverables(List<? extends AbstractCoverable> coverables) {
    this.coverables = coverables;
  }
}
