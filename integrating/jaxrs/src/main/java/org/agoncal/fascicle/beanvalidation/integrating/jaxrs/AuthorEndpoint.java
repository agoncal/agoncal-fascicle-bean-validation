package org.agoncal.fascicle.beanvalidation.integrating.jaxrs;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

// tag::adocSnippet[]
@Path("/authors")
public class AuthorEndpoint {

  @POST
  @Consumes("application/json")
  public Response createAuthor(@Valid Author author) {
    // Stores the author
    return Response.created(UriBuilder.fromResource(AuthorEndpoint.class)
      .path(String.valueOf(author.getId())).build()).build();
  }
  // tag::adocSkip[]

  @GET()
  @Produces("application/json")
  public Response getAuthor() {
    Author author = new Author();
    author.setId(1L);
    author.setFirstName("Douglas");
    author.setLastName("Adams");
    author.setEmail("douglas.adams@h2g2.com");
    return Response.ok(author).build();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
