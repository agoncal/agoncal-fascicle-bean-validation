package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex11;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
  @Size(min = 4, max = 50, message = "{org.agoncal.fascicle.Customer.firstName}")
  private String firstName;
  private String lastName;
  @Email(message = "{org.agoncal.fascicle.Customer.recoveryEmail}")
  private String recoveryEmail;
  private Date dateOfBirth;
  @Min(value = 18, message = "{org.agoncal.fascicle.Customer.age}")
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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
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
