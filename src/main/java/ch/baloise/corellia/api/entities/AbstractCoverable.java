package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonSubTypes({
    @JsonSubTypes.Type(value = Movement.class), //
    @JsonSubTypes.Type(value = Vehicle.class),  //
    @JsonSubTypes.Type(value = Property.class), //
    @JsonSubTypes.Type(value=AnyCoverable.class)}) //
public abstract class AbstractCoverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  @Size(max = 20)
  private String code;

  @NotNull
  private BigDecimal sumInsured;

  @NotNull
  @Valid
  private List<Coverage> coverage;

  public AbstractCoverable() {}

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

  public BigDecimal getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(BigDecimal sumInsured) {
    this.sumInsured = sumInsured;
  }

  public List<Coverage> getCoverage() {
    return coverage;
  }

  public void setCoverage(List<Coverage> coverage) {
    this.coverage = coverage;
  }
}
