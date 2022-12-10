package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex10;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Customer {

  @Email
  private String userId;
  @NotNull
  @Size(min = 4, max = 50, message = "First name length should be between {min} and {max}")
  private String firstName;
  private String lastName;
  @Email(message = "Recovery email is not a valid email address")
  private String recoveryEmail;
  private LocalDate dateOfBirth;
  @Min(value = 18, message = "Customer is too young. Should be older than {value}")
  private Integer age;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Customer() {
  }

  public Customer(String firstName, String lastName, String userId, String recoveryEmail) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = userId;
    this.recoveryEmail = recoveryEmail;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRecoveryEmail() {
    return recoveryEmail;
  }

  public void setRecoveryEmail(String recoveryEmail) {
    this.recoveryEmail = recoveryEmail;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
