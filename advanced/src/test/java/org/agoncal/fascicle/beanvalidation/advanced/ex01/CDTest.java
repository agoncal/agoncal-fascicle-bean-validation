package org.agoncal.fascicle.beanvalidation.advanced.ex01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CDTest {

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
  void shouldRaiseNoConstraintViolation() {

    // Creates a CD with null title
    CD cd = new CD().id(1L).title("Help").price(12.80f).description("Beatles master piece").musicCompany("Apple").numberOfCDs(1).totalDuration(53.32f).genre("Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseConstraintsViolation() {

    // Creates a CD with null title
    CD cd = new CD();

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  void shouldRaiseWrongMusicCompany() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "apple", 1, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseTooManyCDs() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseMusicGenreLowerCase() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  void shouldRaiseMusicGenreTooShort() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "P");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  void shouldRaiseMusicGenreTooLong() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Poooooooooooooooooooooooooooooooooooooooooooooooooooooop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayConstraintViolations(violations);
    assertEquals(2, violations.size());
  }


  @Test
  void shouldRaiseNoConstraintViolationOnCalculateVAT() throws NoSuchMethodException {

    CD cd = new CD(1L, "title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculateVAT");
    Set<ConstraintViolation<CD>> violations = methodValidator.validateReturnValue(cd, method, 10.0f);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseAnExceptionCauseOverriddenMethodCannotHaveConstraintParameters() throws NoSuchMethodException {

    CD cd = new CD(1L, "title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{4.5f});
  }

  private void displayConstraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
