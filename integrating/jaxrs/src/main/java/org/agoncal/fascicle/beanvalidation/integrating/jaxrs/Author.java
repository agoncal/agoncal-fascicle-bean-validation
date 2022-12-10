package org.agoncal.fascicle.beanvalidation.integrating.jaxrs;

import org.hibernate.validator.constraints.Email;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @formatter:off
// tag::adocSnippet[]
public class Author {

  @NotNull
  private Long id;
  @NotNull @Size(min = 2, max = 50)
  private String firstName;
  @NotNull
  private String lastName;
  @Size(max = 2000)
  private String bio;
  @Email
  private String email;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
