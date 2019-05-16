package ch.baloise.corellia.api;

import ch.baloise.corellia.api.entities.Contract;
import ch.baloise.corellia.api.entities.Document;
import ch.baloise.corellia.api.entities.Version;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/contracts/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ContractRestController {


  @POST
  @Operation(summary = "upload a contract at Baloise",
      tags = {"contracts"},
      description = "uploaded a contract to Baloise. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "a handle to the contract for conversation with Baloise is provided", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Contract is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class)))
      })
  public ch.baloise.corellia.api.entities.ContractReference uploadContract(@Parameter(description = "Contract that needs to be uploaded to Baloise", required = true) Contract contract);

  @POST
  @Path("/documents")
  @Operation(summary = "upload a Document for a contract at Baloise.",
      tags = {"documents"},
      description = "Please note that this operation needs to be called per document for a contract to be uploaded. The response contains a handle to the document. This handle should be provided with the contract to be uploaded via uploadContract",
      responses = {
          @ApiResponse(description = "a handle to the document for providing with a new contract to be uploaded via POST contracts", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.FileHandle.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Document is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
      })
  public ch.baloise.corellia.api.entities.FileHandle uploadDocument(@Parameter(description = "a documnent that is part of a contract", required = true) Document document);


  @GET
  @Path("/version")
  @Operation(summary = "callable way of retrieving current version",
      tags = {"version"},
      description = "callable way (compared to analyzing the URL of the endpoint) of retrieving current version. As well good for testing purposes as operation is get only",
      responses = {
          @ApiResponse(description = "version identifier", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.Version.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ErrorResponse.class))),
      })
  public Version version();
}
