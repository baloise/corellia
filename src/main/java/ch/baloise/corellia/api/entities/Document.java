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

import static ch.baloise.corellia.api.constraints.SizeConstraint.CONTRACT_ID_MAX_SIZE;
import static ch.baloise.corellia.api.constraints.SizeConstraint.FILE_NAME_MAX_SIZE;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

public class Document implements Serializable {

  private static final long serialVersionUID = 10;

  public enum MediaType {
    APPLICATION_PDF, IMAGE_JPEG, IMAGE_TIFF, IMAGE_PNG, IMAGE_BMP, IMAGE_GIF;

    private static Map<String, MediaType> ELEMENTS_MAP = Stream.of(MediaType.values()).collect(Collectors.toMap(Enum::name, Function.identity()));

    @JsonCreator // This is the factory method and must be static
    public static MediaType fromString(String string) {
      final String upperCaseString = StringUtils.isEmpty(string) ? "" : string.toUpperCase();
      return Optional.ofNullable(ELEMENTS_MAP.get(upperCaseString)).orElseThrow(() -> new IllegalArgumentException("cannot convert to Enumtype: " + string));
    }
  }
  public enum DocumentType {
    CONTRACT, RECEIPT, INTERNE_KORRESPONDENZ;

    private static Map<String, DocumentType> ELEMENTS_MAP = Stream.of(DocumentType.values()).collect(Collectors.toMap(Enum::name, Function.identity()));

    @JsonCreator // This is the factory method and must be static
    public static DocumentType fromString(String string) {
      final String upperCaseString = StringUtils.isEmpty(string) ? "" : string.toUpperCase();
      return Optional.ofNullable(ELEMENTS_MAP.get(upperCaseString)).orElseThrow(() -> new IllegalArgumentException("cannot convert to Enumtype: " + string));
    }}

  @NotNull
  @JsonPropertyDescription("The document itself")
  private byte[] data;

  @NotNull
  @Size(max = CONTRACT_ID_MAX_SIZE)
  @JsonPropertyDescription("The contract this document belongs to")
  private String contractId;

  @NotNull
  @JsonPropertyDescription("Accepted media types for documents represented by data byte[]")
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
