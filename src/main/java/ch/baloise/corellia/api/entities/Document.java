package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Document implements Serializable {

  private static final long serialVersionUID = 10;

  @NotNull
  private byte[] data;

  @NotNull
  @Size(max = 20)
  private String policyId;

  @NotNull
  @Size(max = 20)
  private String documentType;

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getPolicyId() {
    return policyId;
  }

  public void setPolicyId(String policyId) {
    this.policyId = policyId;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }
}
