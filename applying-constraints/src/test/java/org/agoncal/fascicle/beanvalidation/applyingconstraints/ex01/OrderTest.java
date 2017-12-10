package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  private static Date creationDate;
  private static Date paymentDate;
  private static Date deliveryDate;


  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public static void init() throws ParseException {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    creationDate = dateFormat.parse("01/01/2010");
    paymentDate = dateFormat.parse("02/01/2010");
    deliveryDate = dateFormat.parse("03/01/2045");

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

    Order order = new Order(creationDate);
    order.setOrderId("CA45678");
    order.setTotalAmount(1234.5);
    order.setDeliveryDate(deliveryDate);
    order.addOrderLine(new OrderLine("item", 12d, 2));

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToEmptyLines() {

    Order order = new Order(creationDate);
    order.setOrderId("CA45678");
    order.setTotalAmount(1234.5);
    order.setDeliveryDate(deliveryDate);

    Set<ConstraintViolation<Order>> violations = validator.validate(order);
    assertEquals(1, violations.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
