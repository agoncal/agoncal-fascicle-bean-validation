package org.agoncal.fascicle.beanvalidation.gettingstarted;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest {

  private ValidatorFactory vf;
  private Validator validator;

  @BeforeEach
  public void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterEach
  public void close() {
    vf.close();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  // tag::adocShouldRaiseNoConstraintViolation[]
  @Test
  public void shouldRaiseNoConstraintViolation() {

    Artist book = new Artist().firstName("Adams").lastName("Douglas");

    Set<ConstraintViolation<Artist>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }
  // end::adocShouldRaiseNoConstraintViolation[]

  // tag::shouldRaiseConstraintViolationCauseFirstNameIsNull[]
  @Test
  public void shouldRaiseConstraintViolationCauseFirstNameIsNull() {

    Artist book = new Artist().firstName(null).lastName("Douglas");

    Set<ConstraintViolation<Artist>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }
  // end::shouldRaiseConstraintViolationCauseFirstNameIsNull[]

  // tag::shouldRaiseConstraintViolationCauseInvalidEmail[]
  @Test
  public void shouldRaiseConstraintViolationCauseInvalidEmail() {

    Artist book = new Artist().firstName("Adams").lastName("Douglas").email("wrong");

    Set<ConstraintViolation<Artist>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }
  // end::shouldRaiseConstraintViolationCauseInvalidEmail[]

  // tag::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]
  @Test
  public void shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate() {

    LocalDate dateOfBirth = LocalDate.of(2678,12,01);
    Artist book = new Artist().firstName("Adams").lastName("Douglas").email("wrong").dateOfBirth(dateOfBirth);

    Set<ConstraintViolation<Artist>> violations = validator.validate(book);
    assertEquals(2, violations.size());
  }
  // end::shouldRaiseTwoConstraintViolationsCauseInvalidEmailAndFutureDate[]

}
