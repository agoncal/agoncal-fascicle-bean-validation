package org.agoncal.fascicle.beanvalidation.integrating.jaxrs;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

// tag::adocSnippet[]
@Path("/authors")
public class AuthorEndpoint {

  @POST
  @Consumes("application/json")
  public Response create(@Valid Author author) {
    return Response.created(UriBuilder.fromResource(AuthorEndpoint.class)
      .path(String.valueOf(author.getId())).build()).build();
  }
  // tag::adocSkip[]

  @GET()
  @Produces("text/plain")
  public String helloWorld() {
    return "Hello World";
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
