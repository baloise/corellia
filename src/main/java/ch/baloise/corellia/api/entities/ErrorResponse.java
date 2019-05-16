/**
 * Copyright 2016 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
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
import java.util.List;

public class ErrorResponse {

  @NotNull
  private ErrorCause errorCause;

  @NotNull
  @Size(min = 1, max = 1024)
  @JsonPropertyDescription("information about the error")
  private String message;

  @JsonPropertyDescription("in case of e.g. validation error, each validation error is represented by one detail message")
  private List<String> detailMessages;

  public ErrorResponse(ErrorCause errorCause, String message) {
    this(errorCause, message, null);
  }

  public ErrorResponse(ErrorCause errorCause, String message, List<String> detailMessages) {
    this.errorCause = errorCause;
    this.message = message;
    this.detailMessages = detailMessages;
  }

  public ErrorCause getErrorCause() {
    return errorCause;
  }

  public void setErrorCause(ErrorCause errorCause) {
    this.errorCause = errorCause;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getDetailMessages() {
    return detailMessages;
  }

  public void setDetailMessages(List<String> detailMessages) {
    this.detailMessages = detailMessages;
  }

  public enum ErrorCause {badRequest, inputValidation}
}
