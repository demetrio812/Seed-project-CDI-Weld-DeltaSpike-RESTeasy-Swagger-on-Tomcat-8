package uk.co.novaware.seed.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
@RequestScoped
@Api(value = "/message", description = "Message Test Service")
public class MessageRestService {

    @Inject
    CdiTest test;

    @GET
    @Path("/{param}")
    @ApiOperation("Test method")
    public Response printMessage(@PathParam("param") String msg) {

        String result = "Restful example : " + msg + " - " + test.getTestName();

        return Response.ok(result).build();

    }

}