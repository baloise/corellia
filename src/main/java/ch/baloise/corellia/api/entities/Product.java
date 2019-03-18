package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 20)
  private Integer code;

  @NotNull
  @Valid
  @Size(min = 0, max = 99)
  private List<Coverable> coverables;

  public Product() {}

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public List<Coverable> getCoverables() {
    return coverables;
  }

  public void setCoverables(List<Coverable> coverables) {
    this.coverables = coverables;
  }
}
