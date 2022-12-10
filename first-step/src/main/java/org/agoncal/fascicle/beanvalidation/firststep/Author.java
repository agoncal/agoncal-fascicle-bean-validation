package org.agoncal.fascicle.beanvalidation.firststep;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Author {

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

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Author firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Author lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Author surnbioame(String bio) {
    this.bio = bio;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Author email(String email) {
    this.email = email;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
