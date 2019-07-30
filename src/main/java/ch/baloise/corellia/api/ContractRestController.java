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

import ch.baloise.corellia.api.entities.Contract;
import ch.baloise.corellia.api.entities.Document;
import ch.baloise.corellia.api.entities.Version;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/contracts/v1")
@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public interface ContractRestController {

  String X_EVENT_ID = "X-Event-ID";
  String X_CALLER_NAME = "X-Caller-Name";

  @POST
  @Operation(summary = "Upload a contract to the insurer",
      tags = {"contracts"},
      description = "Uploads a contract. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "A handle to the contract for conversation with the insurer is provided", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Contract is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class)))
      })

  public ch.baloise.corellia.api.entities.ContractReference uploadContract(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "generated uuid"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "Contract that needs to be uploaded to the insurer", required = true) Contract contract);

  @POST
  @Path("/documents")
  @Operation(summary = "Upload a document for a contract.",
      tags = {"documents"},
      description = "Please note that this operation needs to be called per document for a contract to be uploaded. The response contains a handle to the document. This handle should be provided with the contract to be uploaded via uploadContract",
      responses = {
          @ApiResponse(description = "A handle for the uploaded document which can be used in providing a new contract via POST contracts", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.FileHandle.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Document is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
      })
  public ch.baloise.corellia.api.entities.FileHandle uploadDocument(
      @Parameter(in = ParameterIn.HEADER, name= X_CALLER_NAME, required = true, description = "identifying the sender of this event (request) ", //
          schema = @Schema(type = "string", description = "defined by the callee"))
      @HeaderParam(X_CALLER_NAME) String callerName,
      @Parameter(in = ParameterIn.HEADER, name= X_EVENT_ID, required = true, description = "unique identifier per event (request)", //
          schema = @Schema(type = "string", format = "uuid", description = "generated uuid"))
      @HeaderParam(X_EVENT_ID) String eventId,
      @Parameter(description = "a documnent that is part of a contract", required = true) Document document);


  @GET
  @Path("/version")
  @Operation(summary = "Callable way of retrieving current API version (following semver)",
      tags = {"version"},
      description = "Callable way (compared to analyzing the URL of the endpoint) of retrieving current API version (following semver). As well good for testing purposes as operation is get only",
      responses = {
          @ApiResponse(description = "Version identifier", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.Version.class))),
          @ApiResponse(responseCode = "503", description = "Technical issue on server side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
      })
  public Version version();
}
