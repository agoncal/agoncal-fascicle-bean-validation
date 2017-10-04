package org.agoncal.fascicle.beanvalidation.gettingstarted.ex01;

import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * <p>
 * <p>
 * http://www.antoniogoncalves.org
 * --
 */
public class ArtistTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected ValidatorFactory vf;
  protected Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeEach
  public void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterEach
  public void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() {

    Artist book = new Artist().firstName("Adams").lastName("Douglas");

    Set<ConstraintViolation<Artist>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  // @Test
  // public void shouldRaiseConstraintViolationCausePriceLow() {
  //
  //   Artist book = new Artist("H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);
  //
  //   Set<ConstraintViolation<Artist>> violations = validator.validate(book);
  //   displayContraintViolations(violations);
  //   assertEquals(1, violations.size());
  // }
  //
  // @Test
  // public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() {
  //
  //   Artist book = new Artist();
  //
  //   Set<ConstraintViolation<Artist>> violations = validator.validate(book);
  //   displayContraintViolations(violations);
  //   assertEquals(2, violations.size());
  // }
  //
  // @Test
  // public void shouldRaiseConstraintsViolationCauseValidatingOnlyTitle() {
  //
  //   Artist book = new Artist();
  //
  //   Set<ConstraintViolation<Artist>> violations = validator.validateProperty(book, "title");
  //   displayContraintViolations(violations);
  //   assertEquals(1, violations.size());
  // }
  //
  // @Test
  // public void shouldRaiseConstraintsViolationCheckingTheTitleValue() {
  //
  //   Set<ConstraintViolation<Artist>> violations = validator.validateValue(Artist.class, "title", null);
  //   displayContraintViolations(violations);
  //   assertEquals(1, violations.size());
  // }
  //
  // private void displayContraintViolations(Set<ConstraintViolation<Artist>> constraintViolations) {
  //   for (ConstraintViolation constraintViolation : constraintViolations) {
  //     System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
  //       "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());
  //
  //   }
  // }
}
