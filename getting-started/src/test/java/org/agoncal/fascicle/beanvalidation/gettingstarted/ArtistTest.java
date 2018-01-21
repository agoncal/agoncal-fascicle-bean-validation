package org.agoncal.fascicle.beanvalidation.gettingstarted;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest {

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

  // tag::adocShouldRaiseNoConstraintViolation[]
  @Test
  void shouldRaiseNoConstraintViolation() {

    Artist artist = new Artist().firstName("Adams").lastName("Douglas");

    Set<ConstraintViolation<Artist>> violations = validator.validate(artist);
    assertTrue(violations.isEmpty());
  }
  // end::adocShouldRaiseNoConstraintViolation[]

  // tag::shouldRaiseConstraintViolationCauseFirstNameIsNull[]
  @Test
  void shouldRaiseConstraintViolationCauseFirstNameIsNull() {

    Artist artist = new Artist().firstName(null).lastName("Douglas");

    Set<ConstraintViolation<Artist>> violations = validator.validate(artist);
    assertEquals(1, violations.size());
  }
  // end::shouldRaiseConstraintViolationCauseFirstNameIsNull[]

  // tag::shouldRaiseConstraintViolationCauseInvalidEmail[]
  @Test
  void shouldRaiseConstraintViolationCauseInvalidEmail() {

    Artist artist = new Artist().firstName("Adams").lastName("Douglas").email("wrong");

    Set<ConstraintViolation<Artist>> violations = validator.validate(artist);
    assertEquals(1, violations.size());

    ConstraintViolation<Artist> violation = violations.iterator().next();
    assertEquals("must be a well-formed email address", violation.getMessage());
    assertEquals("wrong", violation.getInvalidValue());
    assertEquals("email", violation.getPropertyPath().toString());
  }
  // end::shouldRaiseConstraintViolationCauseInvalidEmail[]

  // tag::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]
  @Test
  void shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate() {

    LocalDate dateOfBirth = LocalDate.of(2678, 12, 01);
    Artist artist = new Artist().firstName("Adams").lastName("Douglas").email("wrong").dateOfBirth(dateOfBirth);

    Set<ConstraintViolation<Artist>> violations = validator.validate(artist);
    assertEquals(2, violations.size());
  }
  // end::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]
}
