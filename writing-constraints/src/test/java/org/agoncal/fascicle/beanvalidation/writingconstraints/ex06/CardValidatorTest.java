package org.agoncal.fascicle.beanvalidation.writingconstraints.ex06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CardValidatorTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterClass
  public static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

    CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
    assertEquals(0, violations.size());

    violations = methodValidator.validateReturnValue(cardValidator, method, Boolean.TRUE);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseCreditCardIsNull() throws NoSuchMethodException {

    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{null});
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseCreditCardParametersAreNull() throws NoSuchMethodException {

    CreditCard creditCard = new CreditCard(null, null, null, null);
    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
    displayContraintViolations(violations);
    assertEquals(3, violations.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<CardValidator>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
