package ch.baloise.corellia.api;

import ch.baloise.corellia.api.entities.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// TODO: 13.03.2019 b021719 implement Errorhandling - throw Exceptions?
@Path("/contracts/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContractRestController {


  @POST
  @Operation(summary = "upload a contract at Baloise",
      tags = {"contracts"},
      description = "uploaded a contract to Baloise. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "a handle to the contract for conversation with Baloise is provided", content = @Content(schema = @Schema(implementation = ContractReference.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Contract is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
      })
  public ContractReference saveContract(@Parameter(description = "Contract that needs to be uploaded to Baloise", required = true) Contract contract) {
    return new ContractReference();
  }

  @POST
  @Path("/documents")
  @Operation(summary = "upload a Document for a contract at Baloise.",
      tags = {"documents"},
      description = "Please note that this operation needs to be called per document for a contract to be saved. The response contains a handle to the document. This handle should be provided with the contract to be saved via saveContract",
      responses = {
          @ApiResponse(description = "a handle to the document for providing with a new contract to be saved via POST contracts", content = @Content(schema = @Schema(implementation = FileHandle.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Document is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
      })
  public FileHandle saveDocument(@Parameter(description = "a documnent that is part of a contract", required = true) Document document) {
    return new FileHandle();
  }
}
