package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CardValidatorTest {

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
  void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

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
  void shouldRaiseConstraintViolationCauseCreditCardIsNull() throws NoSuchMethodException {

    CardValidator cardValidator = new CardValidator();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator.class.getMethod("validate", CreditCard.class);
    Set<ConstraintViolation<CardValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{null});
    displayConstraintViolations(violations);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<CardValidator>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
