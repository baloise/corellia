package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Document implements Serializable {

  private static final long serialVersionUID = 10;

  public enum MediaType {application_pdf, image_jpeg, image_tiff}
  public enum DocumentType {contract, receipt}

  @NotNull
  @JsonPropertyDescription("the document itself")
  private byte[] data;

  @NotNull
  @Size(max = 30)
  @JsonPropertyDescription("the contract this document belongs to")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("accepted media types for documents represented by data byte[]")
  private MediaType mediaType;

  @NotNull
  @Size(max = 256)
  private String fileName;

  @NotNull
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

  public MediaType getMediaType() {
    return mediaType;
  }

  public void setMediaType(MediaType mediaType) {
    this.mediaType = mediaType;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
}
