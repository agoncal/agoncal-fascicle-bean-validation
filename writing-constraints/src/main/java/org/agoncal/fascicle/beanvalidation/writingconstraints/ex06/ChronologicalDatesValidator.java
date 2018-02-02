package org.agoncal.fascicle.beanvalidation.writingconstraints.ex06;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {

  @Override
  public boolean isValid(Order order, ConstraintValidatorContext ctx) {
    if (order.getCreationDate()==null || order.getDeliveryDate() == null || order.getPaymentDate() == null)
      return true;

    return order.getCreationDate().isBefore(order.getPaymentDate()) &&
           order.getPaymentDate().isBefore(order.getDeliveryDate());
  }
}
// end::adocSnippet[]
