package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex04;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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

    Order order = new Order("CA45678", 1234.5);
    order.addOrderLine(new OrderLine("item", 12d, 2));
    order.addEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToNullLines() {

    Order order = new Order("CA45678", 1234.5);
    order.setOrderLines(null);
    order.addEmail("agoncal.fascicle@gmail.com");

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToNullEmails() {

    Order order = new Order("CA45678", 1234.5);
    order.addOrderLine(new OrderLine("item", 12d, 2));
    order.setEmails(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToNullEmail() {

    Order order = new Order("CA45678", 1234.5);
    order.addOrderLine(new OrderLine("item", 12d, 2));
    order.addEmail(null);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToEmptyEmail() {

    Order order = new Order("CA45678", 1234.5);
    order.addOrderLine(new OrderLine("item", 12d, 2));
    order.addEmail("");

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToInvalidEmail() {

    Order order = new Order("CA45678", 1234.5);
    order.addOrderLine(new OrderLine("item", 12d, 2));
    order.addEmail("dummy");

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
