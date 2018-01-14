package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  public static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() {

    // Creates a book
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "recovery@gmail.com");


    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseEmailWithoutAt() {

    // Creates a book
    Customer customer = new Customer("John", "Smith", "jsmithgmail.com", "recovery@gmail.com");

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseFirstnameIsNull() {

    // Creates a book
    Customer customer = new Customer();

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldCheckEmailDefaultMessage() {

    // Creates a book
    Customer customer = new Customer("John", "Smith", "dummy", "recovery@gmail.com");

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("must be a well-formed email address", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldCheckEmailCustomMessage() {

    // Creates a book
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "dummy");

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("The recovery email is not a valid email address", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldCheckAgeMessage() {

    // Creates a book
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "recovery@gmail.com");
    customer.setAge(10);

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("Customer is too young. He/she should be older than 18", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldCheckFirstnameMessage() {

    // Creates a book
    Customer customer = new Customer("J", "Smith", "jsmith@gmail.com", "recovery@gmail.com");

    // Validate the cd
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("The customer firstname should be between 4 and 50", violations.iterator().next().getMessage());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Customer>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
