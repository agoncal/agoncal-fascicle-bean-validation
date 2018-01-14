package org.agoncal.fascicle.beanvalidation.puttingtogether;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
// tag::adocSnippet[]
public class OrderTest {

  private static ValidatorFactory vf;
  private static Validator validator;

  @BeforeAll
  public static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  public static void close() {
    vf.close();
  }

  // ...
  // end::adocSnippet[]
  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintsViolation() {

    // tag::shouldRaiseNoConstraintsViolation[]
    Order order = new Order().id(1234L).totalAmount(40.5).creationDate(LocalDate.MIN);
    order.setCustomer(new Customer().firstName("Antonio").lastName("goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolation[]
  }

  @Test
  public void shouldRaiseNoConstraintsViolationEvenWithNoAddress() {

    // tag::shouldRaiseNoConstraintsViolationEvenWithNoAddress[]
    Order order = new Order().id(1234L).totalAmount(40.5).creationDate(LocalDate.MIN);
    order.setCustomer(new Customer().firstName("Antonio").lastName("goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintsViolationEvenWithNoAddress[]
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseNullCustomer() {

    // tag::shouldRaiseConstraintsViolationCauseNullCustomer[]
    Order order = new Order().id(1234L).totalAmount(40.5).creationDate(LocalDate.MIN);
    order.setCustomer(null);
    order.add(new OrderLine().item("Help").quantity(1).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());

    for (ConstraintViolation constraintViolation : violations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());
    }
    // end::shouldRaiseConstraintsViolationCauseNullCustomer[]
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseNullQuantity() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantity[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.setCustomer(new Customer().firstName("Antonio").lastName("goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(15d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullQuantity[]
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice() {

    // tag::shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice[]
    Order order = new Order().id(1234L).totalAmount(40.5);
    order.setCustomer(new Customer().firstName("Antonio").lastName("goncalves").email("agoncal.fascicle@gmail.com"));
    order.setDeliveryAddress(new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA"));
    order.add(new OrderLine().item("Help").quantity(null).unitPrice(10.5));
    order.add(new OrderLine().item("Sergeant Pepper").quantity(2).unitPrice(-99d));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintsViolationCauseNullQuantityNegativePrice[]
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
