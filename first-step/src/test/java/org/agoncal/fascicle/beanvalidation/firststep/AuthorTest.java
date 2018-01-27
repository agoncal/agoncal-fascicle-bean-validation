package org.agoncal.fascicle.beanvalidation.firststep;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorTest {

  private static ValidatorFactory vf;
  private static Validator validator;

  @BeforeAll
  static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  static void close() {
    vf.close();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintViolation() {

    // tag::adocShouldRaiseNoConstraintViolation[]
    Author author = new Author().firstName("Adams").lastName("Douglas");

    Set<ConstraintViolation<Author>> violations = validator.validate(author);
    assertTrue(violations.isEmpty());
    // end::adocShouldRaiseNoConstraintViolation[]
  }

  @Test
  void shouldRaiseConstraintViolationCauseFirstNameIsNull() {

    Author author = new Author().firstName(null).lastName("Douglas");

    Set<ConstraintViolation<Author>> violations = validator.validate(author);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseConstraintViolationCauseInvalidEmail() {

    // tag::shouldRaiseConstraintViolationCauseInvalidEmail[]
    Author author = new Author().firstName("Adams").lastName("Douglas").email("wrong");

    Set<ConstraintViolation<Author>> violations = validator.validate(author);
    assertEquals(1, violations.size());

    ConstraintViolation<Author> violation = violations.iterator().next();
    assertEquals("must be a well-formed email address", violation.getMessage());
    assertEquals("wrong", violation.getInvalidValue());
    assertEquals("email", violation.getPropertyPath().toString());
    // end::shouldRaiseConstraintViolationCauseInvalidEmail[]
  }

  @Test
  void shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate() {

    Author author = new Author().firstName("Adams").lastName("Douglas").email("wrong");

    Set<ConstraintViolation<Author>> violations = validator.validate(author);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Author>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
