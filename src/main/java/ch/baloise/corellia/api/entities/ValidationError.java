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

import java.util.List;

public class ValidationError {
  @JsonPropertyDescription("the path to the invalid value")
  private String path;

  @JsonPropertyDescription("a list of error causes")
  private List<ErrorCause> errorCauses;

  public enum ErrorCause {
    REQUIRED, SIZE, INVALID_VALUE
  }

  public List<ErrorCause> getErrorCauses() {
    return errorCauses;
  }

  public void setErrorCauses(List<ErrorCause> errorCauses) {
    this.errorCauses = errorCauses;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public String toString() {
    return "ValidationError{" +
      "path='" + path + '\'' +
      ", errorCauses=" + errorCauses +
      '}';
  }

}
