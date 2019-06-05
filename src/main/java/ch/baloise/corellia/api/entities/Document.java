/*
 * Copyright 2018 Baloise Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_ID_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.FILE_NAME_MAX_SIZE;

public class Document implements Serializable {

  private static final long serialVersionUID = 10;

  public enum MediaType {application_pdf, image_jpeg, image_tiff}
  public enum DocumentType {contract, receipt}

  @NotNull
  @JsonPropertyDescription("the document itself")
  private byte[] data;

  @NotNull
  @Size(max = CONTRACT_ID_MAX_SIZE)
  @JsonPropertyDescription("the contract this document belongs to")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("accepted media types for documents represented by data byte[]")
  private MediaType mediaType;

  @NotNull
  @Size(max = FILE_NAME_MAX_SIZE)
  private String fileName;

  @NotNull
  private DocumentType documentType;

  public Document() {
  }

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
