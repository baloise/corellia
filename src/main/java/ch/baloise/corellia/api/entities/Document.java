package ch.baloise.corellia.api.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Document implements Serializable {

  public enum DocumentType { contract, receipt};

  private static final long serialVersionUID = 10;

  @NotNull
  private byte[] data;

  @NotNull
  @Size(max = 20)
  private String contractId;

  @NotNull
  @Size(max = 20)
  private DocumentType documentType;

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  public DocumentType getDocumentType() {
    return documentType;
  }

  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }
}
