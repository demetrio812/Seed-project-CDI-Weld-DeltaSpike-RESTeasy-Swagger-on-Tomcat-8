package uk.co.novaware.seed.ws;

import org.jboss.resteasy.spi.DefaultOptionsMethodException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultOptionsMethodExceptionHandler implements ExceptionMapper<DefaultOptionsMethodException> {

    public Response toResponse(DefaultOptionsMethodException exception) {
        return Response
                .status(Response.Status.OK)
                .build();
    }
}
