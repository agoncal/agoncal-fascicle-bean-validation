package org.agoncal.fascicle.beanvalidation.advanced.ex02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
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
  void shouldRaiseNoConstraintsViolationCauseOnlyCreation() {

    // tag::shouldRaiseNoConstraintsViolationCauseOnlyCreation[]
    Order order = new Order().id(1234L).totalAmount(1234.5);

    order.setCreationDate(LocalDate.parse("2017-01-10"));
    order.setPaymentDate(null);
    order.setDeliveryDate(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationCauseOnlyCreation[]
  }

  @Test
  void shouldRaiseNoConstraintsViolationCauseOnlyCreationDefaultGroup() {

    // tag::shouldRaiseNoConstraintsViolationCauseOnlyCreationDefaultGroup[]
    Order order = new Order().id(1234L).totalAmount(1234.5);

    order.setCreationDate(LocalDate.parse("2017-01-10"));
    order.setPaymentDate(null);
    order.setDeliveryDate(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order, Default.class);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationCauseOnlyCreationDefaultGroup[]
  }

  @Test
  void shouldRaiseConstraintsViolationCausePaymentGroup() {

    // tag::shouldRaiseConstraintsViolationCausePaymentGroup[]
    Order order = new Order().id(1234L).totalAmount(1234.5);

    order.setCreationDate(LocalDate.parse("2017-01-10"));
    order.setPaymentDate(null);
    order.setDeliveryDate(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order, Payment.class);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCausePaymentGroup[]
  }

  @Test
  void shouldRaiseNoConstraintsViolationCauseDeliveryGroup() {

    // tag::shouldRaiseNoConstraintsViolationCauseDeliveryGroup[]
    Order order = new Order().id(1234L).totalAmount(1234.5);

    order.setCreationDate(LocalDate.parse("2017-01-10"));
    order.setPaymentDate(LocalDate.parse("2017-01-20"));
    order.setDeliveryDate(LocalDate.parse("2017-01-30"));

    Set<ConstraintViolation<Order>> violations = validator.validate(order, Delivery.class);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationCauseDeliveryGroup[]
  }

  @Test
  void shouldRaiseConstraintsViolationCauseDeliveryGroup() {

    // tag::shouldRaiseConstraintsViolationCauseDeliveryGroup[]
    Order order = new Order().id(1234L).totalAmount(1234.5);

    order.setCreationDate(LocalDate.parse("2017-01-30"));
    order.setPaymentDate(LocalDate.parse("2017-01-20"));
    order.setDeliveryDate(LocalDate.parse("2017-01-10"));

    Set<ConstraintViolation<Order>> violations = validator.validate(order, Delivery.class);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseDeliveryGroup[]
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
