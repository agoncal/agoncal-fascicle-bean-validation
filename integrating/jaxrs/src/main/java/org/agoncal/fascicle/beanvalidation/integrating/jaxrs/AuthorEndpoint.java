package org.agoncal.fascicle.beanvalidation.integrating.jaxrs;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

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
