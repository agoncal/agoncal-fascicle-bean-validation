package org.agoncal.fascicle.beanvalidation.gettingstarted;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Artist {

  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @Email
  private String email;
  @Size(max = 2000)
  private String bio;
  @Past
  private LocalDate dateOfBirth;

  // Constructors, getters, setters
  // tag::adocSnippet[]

  public Artist() {
  }

  public Artist(String firstName, String lastName, String email, String bio, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
  }


  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Artist firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Artist lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Artist email(String email) {
    this.email = email;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Artist bio(String bio) {
    this.bio = bio;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Artist dateOfBirth(LocalDate bio) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Artist{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", bio='" + bio + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      '}';
  }
  // end::adocSnippet[]
}
// end::adocSnippet[]
