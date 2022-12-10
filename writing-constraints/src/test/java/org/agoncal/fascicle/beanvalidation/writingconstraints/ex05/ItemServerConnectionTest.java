package org.agoncal.fascicle.beanvalidation.writingconstraints.ex05;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

    ItemServerConnection itemServer = new ItemServerConnection("dummy", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("dummy", violations.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidProtocol() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "ftp://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("ftp://www.cdbookstore.com/book/1334", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid protocol", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidHost() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.dummy.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("http://www.dummy.com/book/1334", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid host", violations.iterator().next().getMessage());
  }

  @Test
  void shouldRaiseConstraintsViolationCauseInvalidPort() {

    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:22");

    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("ftp://www.cdbookstore.com:22", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid port", violations.iterator().next().getMessage());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<ItemServerConnection>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
