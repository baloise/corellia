package ch.baloise.corellia.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Vehicle extends AbstractCoverable implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  @Size(max = 100)
  private String frameNumber;

  @NotNull
  @Size(max = 100)
  private String type;

  @NotNull
  @Size(max = 100)
  private String brand;

  @NotNull
  @Size(max = 100)
  private String model;

  @NotNull
  private Date firstRegistration;

  @NotNull
  @Size(max = 100)
  private String matriculationNumber;

  @NotNull
  @Size(max = 2)
  private String plateCanton;

  @NotNull
  @Size(max = 10)
  private String plateNumber;

  public Vehicle() {}

  public String getFrameNumber() {
    return frameNumber;
  }

  public void setFrameNumber(String frameNumber) {
    this.frameNumber = frameNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Date getFirstRegistration() {
    return firstRegistration;
  }

  public void setFirstRegistration(Date firstRegistration) {
    this.firstRegistration = firstRegistration;
  }

  public String getMatriculationNumber() {
    return matriculationNumber;
  }

  public void setMatriculationNumber(String matriculationNumber) {
    this.matriculationNumber = matriculationNumber;
  }

  public String getPlateCanton() {
    return plateCanton;
  }

  public void setPlateCanton(String plateCanton) {
    this.plateCanton = plateCanton;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }
}
