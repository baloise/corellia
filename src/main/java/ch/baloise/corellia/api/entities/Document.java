package ch.baloise.corellia.api.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Document implements Serializable {

  private static final long serialVersionUID = 10;

  ;
  @NotNull
  @Schema(description = "the document itself")
  private byte[] data;
  @NotNull
  @Size(max = 20)
  @Schema(description = "the contract this document belongs to")
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

  public enum DocumentType {contract, receipt}
}
