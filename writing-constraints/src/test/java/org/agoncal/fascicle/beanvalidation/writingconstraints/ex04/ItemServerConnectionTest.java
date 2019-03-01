package org.agoncal.fascicle.beanvalidation.writingconstraints.ex04;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ItemServerConnectionTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static ValidatorFactory vf;
  private static Validator validator;


  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldRaiseNoConstraintsViolation() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

    ItemServerConnection itemServer = new ItemServerConnection("dummy", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("dummy", violations.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidItemURL() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/123", "dummy", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("dummy", violations.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidFTPServerURL() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "dummy");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("dummy", violations.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidURLs() {

    ItemServerConnection itemServer = new ItemServerConnection("dummy1", "dummy2", "dummy3");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(3, violations.size());
  }

  @Test
  void shouldRaiseExceptionAsDateIsNotAURL() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");
    itemServer.setLastConnectionDate(Instant.now());

    assertThrows(javax.validation.ValidationException.class, () -> {
      validator.validate(itemServer, Error.class);
    });
  }

  private void displayConstraintViolations(Set<ConstraintViolation<ItemServerConnection>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
