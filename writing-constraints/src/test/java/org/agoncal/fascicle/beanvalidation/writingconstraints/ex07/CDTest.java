package org.agoncal.fascicle.beanvalidation.writingconstraints.ex07;

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

    // Creates a CD with null title
    CD cd = new CD(1L, "title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintsViolation() {

    // Creates a CD with null title
    CD cd = new CD();

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseWrongMusicCompany() throws Exception {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "apple", 1, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseTooManyCDs() throws Exception {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreLowerCase() throws Exception {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "pop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreTooShort() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "P");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreTooLong() {

    // Creates a cd
    CD cd = new CD(1L, "St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Poooooooooooooooooooooooooooooooooooooooooooooooooooooop");

    // Validate the cd
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }


  @Test
  public void shouldRaiseNoConstraintViolationOnCalculateVAT() throws NoSuchMethodException {

    CD cd = new CD(1L, "title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculateVAT");
    Set<ConstraintViolation<CD>> violations = methodValidator.validateReturnValue(cd, method, new Float(10.0));
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseAnExceptionCauseOverriddenMethodCannotHaveConstraintParameters() throws NoSuchMethodException {

    CD cd = new CD(1L, "title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(4.5)});
  }

  private void displayContraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
