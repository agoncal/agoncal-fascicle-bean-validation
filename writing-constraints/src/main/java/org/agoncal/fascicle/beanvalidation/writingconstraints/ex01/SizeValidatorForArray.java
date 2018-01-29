package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

public class SizeValidatorForArray implements ConstraintValidator<Size, Object[]> {
  private int min;
  private int max;

  @Override
  public void initialize(Size parameters) {
    this.min = parameters.min();
    this.max = parameters.max();
  }

  // tag::adocIsValid[]
  @Override
  public boolean isValid(Object[] array, ConstraintValidatorContext ctx) {
    if (array == null) {
      return true;
    } else {
      return array.length >= this.min && array.length <= this.max;
    }
  }
  // end::adocIsValid[]
}
