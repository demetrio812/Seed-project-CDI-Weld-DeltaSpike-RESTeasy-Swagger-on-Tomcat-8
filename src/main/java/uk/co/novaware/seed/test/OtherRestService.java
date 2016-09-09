package uk.co.novaware.seed.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/other")
@RequestScoped
@Api(value = "/other", description = "Message Test Service")
public class OtherRestService {

    @Inject
    CdiTest test;

    @GET
    @Path("/{param}")
    @ApiOperation("Other test method")
    public Response printMessage(@PathParam("param") String msg) {

        String result = "Other restful example : " + msg + " - " + test.getTestName();

        return Response.status(200).entity(result).build();

    }

}