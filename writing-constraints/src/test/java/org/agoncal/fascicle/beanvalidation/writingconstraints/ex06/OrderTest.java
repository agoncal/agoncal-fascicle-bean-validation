package org.agoncal.fascicle.beanvalidation.writingconstraints.ex06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderTest {

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

    // tag::shouldRaiseNoConstraintsViolation[]
    Order order = new Order();
    order.setCreationDate(LocalDate.parse("2018-01-10"));
    order.setPaymentDate(LocalDate.parse("2018-01-20"));
    order.setDeliveryDate(LocalDate.parse("2018-01-30"));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolation[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseDatesAreNotChronological() {

    // tag::shouldRaiseConstraintsViolationCauseDatesAreNotChronological[]
    Order order = new Order();
    order.setCreationDate(LocalDate.parse("2018-01-30"));
    order.setPaymentDate(LocalDate.parse("2018-01-20"));
    order.setDeliveryDate(LocalDate.parse("2018-01-10"));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseDatesAreNotChronological[]
  }

  @Test
  void shouldRaiseNoConstraintsViolationCauseNullDate() {

    // tag::shouldRaiseNoConstraintsViolationCauseNullDate[]
    Order order = new Order();
    order.setCreationDate(null);
    order.setPaymentDate(null);
    order.setDeliveryDate(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationCauseNullDate[]
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
