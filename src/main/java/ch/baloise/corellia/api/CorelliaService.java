package ch.baloise.corellia.api;

import ch.baloise.corellia.api.entities.Contract;
import ch.baloise.corellia.api.entities.Document;

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
import javax.ws.rs.core.Response;

//@Path("/contract/1.0.0")
// TODO: 13.03.2019 b021719 enable versioning
// TODO: 13.03.2019 b021719 implement Errorhandling - throw Exceptions?
// TODO: 15.03.2019 Resource path überarbeitenn
@Path("/contract")
@Produces(MediaType.APPLICATION_JSON)
public class CorelliaService {


  @POST
  @Consumes("application/json")
  @Path("/contracts")
  @Operation(summary = "save a contract at Baloise",
      tags = {"contracts"},
      description = "accepts a contract to be saved and processed at Baloise. If validation fails processing is refused, a corresponding error is thrown",
      responses = {
          @ApiResponse(description = "a handle to the contract for conversation with Baloise is provided", content = @Content(schema = @Schema(implementation = Response.class))),
          // TODO: 15.03.2019 b021719 , content = @Content(schema = @Schema(implementation=ApiResponse.class)
          @ApiResponse(responseCode = "400", description = "Invalid Contract is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ApiResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ApiResponse.class)))
      })
  public Response saveContract(@Parameter(description = "Contract that needs to be transmitted at Baloise", required = true) Contract contract) {
    return Response.ok().entity("SUCCESS").build();
  }

  @POST
  @Consumes("application/json")
  @Path("/documents")
  @Operation(summary = "save a Document for a contract at Baloise.",
      tags = {"documents"},
      description = "Please note that this operation needs to be called per document for a contract to be saved. The response contains a handle to the document. This handle should be provided with the contract to be saved via saveContract",
      responses = {
          @ApiResponse(description = "a handle to the document for providing with a new contract to be saved via saveContract", content = @Content(schema = @Schema(implementation = Response.class))),
          @ApiResponse(responseCode = "400", description = "Invalid Document is provided. See Error details for more information about validation issues", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ApiResponse.class))),
          @ApiResponse(responseCode = "503", description = "technical issue on our side, please retry later", content = @Content(schema = @Schema(implementation = ch.baloise.corellia.api.entities.ApiResponse.class))),
      })
  public Response saveDocument(@Parameter(description = "a documnent that is part of a contract", required = true) Document document) {
    return Response.ok().entity("SUCCESS").build();
  }
}
