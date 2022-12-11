package org.agoncal.fascicle.beanvalidation.integrating.jsf;

import org.hibernate.validator.constraints.Email;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @formatter:off
// tag::adocSnippet[]
@Named
@RequestScoped
public class Credentials {

  @NotNull @Email
  private String username;

  @NotNull @Size(min = 8, max = 20)
  private String password;

  public String login() {
    // Check user
    return null;
  }
  // tag::adocSkip[]
  // @formatter:on

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
