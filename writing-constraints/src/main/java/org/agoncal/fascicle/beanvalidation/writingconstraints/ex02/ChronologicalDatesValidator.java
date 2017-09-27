package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {

  @Override
  public boolean isValid(Order order, ConstraintValidatorContext context) {
    return order.getCreationDate().getTime() < order.getPaymentDate().getTime() && order.getPaymentDate().getTime() < order.getDeliveryDate().getTime();
  }
}
// end::adocSnippet[]
