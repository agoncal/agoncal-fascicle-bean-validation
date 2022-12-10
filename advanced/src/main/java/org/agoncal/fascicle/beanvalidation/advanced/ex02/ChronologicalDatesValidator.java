package org.agoncal.fascicle.beanvalidation.advanced.ex02;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {

  @Override
  public boolean isValid(Order order, ConstraintValidatorContext context) {
    return order.getCreationDate().isBefore(order.getPaymentDate()) && order.getPaymentDate().isBefore(order.getDeliveryDate());
  }
}
