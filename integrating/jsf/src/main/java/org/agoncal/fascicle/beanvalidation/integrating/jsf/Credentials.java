package org.agoncal.fascicle.beanvalidation.integrating.jsf;

import org.hibernate.validator.constraints.Email;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// @formatter:off
// tag::adocSnippet[]
@Named
@RequestScoped
public class Credentials {

  @NotNull @Email
  private String login;

  @NotNull @Size(min = 8, max = 20)
  private String password;

  public String loggingIn() {
    // Check user
    return null;
  }
  // @formatter:on
  // end::adocSnippet[]

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
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
