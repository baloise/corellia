package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Coverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Schema(description = "a code uniquely identifying a type of coverable")
  private Integer code;

  @NotNull
  @Valid
  @Size(min = 1, max=99)
  private List<Coverage> coverage;

  public Coverable() {}

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public List<Coverage> getCoverage() {
    return coverage;
  }

  public void setCoverage(List<Coverage> coverage) {
    this.coverage = coverage;
  }
}
