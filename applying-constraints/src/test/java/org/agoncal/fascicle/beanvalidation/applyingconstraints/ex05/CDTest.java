package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex05;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.HashMap;
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

    CD cd = new CD("Help", "EMI");
    cd.addTrack(1, "Help!");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToEmpty() {

    CD cd = new CD("Help", "EMI");
    cd.addTrack(1, "");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToNegative() {

    CD cd = new CD("Help", "EMI");
    cd.addTrack(-1, "Help!");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToMax() {

    CD cd = new CD("Help", "EMI");
    cd.addTrack(1, "Help!");
    cd.addTrack(2, "The Night Before");
    cd.addTrack(3, "You've Got to Hide Your Love Away");
    cd.addTrack(4, "I Need You");
    cd.addTrack(5, "Another Girl");
    cd.addTrack(6, "You're Going to Lose That Girl");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToEmptyMap() {

    CD cd = new CD("Help", "EMI");
    cd.setTracks(new HashMap<>());

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }

  @Test
  void shouldRaiseViolationDueToNullMap() {

    CD cd = new CD("Help", "EMI");
    cd.setTracks(null);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
