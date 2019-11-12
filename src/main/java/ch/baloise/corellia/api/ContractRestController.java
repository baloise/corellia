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
package ch.baloise.corellia.api;

import ch.baloise.corellia.api.entities.Cancellation;
import ch.baloise.corellia.api.entities.Contract;
import ch.baloise.corellia.api.entities.ContractV1;
import ch.baloise.corellia.api.entities.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/contracts")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public interface ContractRestController {

  String X_EVENT_ID = "X-Event-ID";
  String X_CALLER_NAME = "X-Caller-Name";

  @Path("/v1")
  @POST
  @Operation(summary = "Upload a contract V1 to the insurer.",
      tags = {"contracts"},
      description = "Uploads a contract. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "A handle to the contract for conversation with the insurer is provided", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid contract is provided. See ErrorResponse for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class)))
      })

  public ch.baloise.corellia.api.entities.ContractReference uploadContractV1(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "Identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "Defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "Unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "Generated UUID"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "Contract that needs to be uploaded to the insurer", required = true) ContractV1 contractV1);

  @Path("/v2")
  @POST
  @Operation(summary = "Upload a contract to the insurer.",
      tags = {"contracts"},
      description = "Uploads a contract. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "A handle to the contract for conversation with the insurer is provided", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid contract is provided. See ErrorResponse for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class)))
      })

  public ch.baloise.corellia.api.entities.ContractReference uploadContract(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "Identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "Defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "Unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "Generated UUID"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "Contract that needs to be uploaded to the insurer", required = true) Contract contract);

  @POST
  @Path("/v1/cancellations")
  @Operation(summary = "cancel a contract",
      tags = {"contracts"},
      description = "cancels a contract. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "A handle to the contract which was cancelled. It's intended for conversation between consumer and insurer", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid cancellation is provided. See ErrorResponse for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class)))
      })

  public ch.baloise.corellia.api.entities.ContractReference cancelContract(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "Identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "Defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "Unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "Generated UUID"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "Cancellation to instruct the insurer to cancel the contract", required = true) Cancellation cancellation);

  @POST
  @Path("/v1/documents")
  @Operation(summary = "Upload a document for a contract.",
      tags = {"documents"},
      description = "Please note that this operation needs to be called per document for a contract to be uploaded. The response contains a handle to the document. This handle should be provided with the contract to be uploaded via uploadContract",
      responses = {
          @ApiResponse(description = "A handle for the uploaded document which can be used in providing a new contract via POST contracts", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.FileHandle.class))),
          @ApiResponse(responseCode = "400", description = "Invalid document is provided. See ErrorResponse for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
      })
  public ch.baloise.corellia.api.entities.FileHandle uploadDocument(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "Identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "Defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "Unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "Generated UUID"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "a documnent that is part of a contract", required = true) Document document);
}
