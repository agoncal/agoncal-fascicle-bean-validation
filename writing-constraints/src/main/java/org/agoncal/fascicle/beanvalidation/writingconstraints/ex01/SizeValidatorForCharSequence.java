package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validate that the object is not {@code null}.
 *
 * @author Emmanuel Bernard
 */
public class SizeValidatorForCharSequence implements ConstraintValidator<Size, CharSequence> {
  private int min;
  private int max;

  public SizeValidatorForCharSequence() {
  }

  public void initialize(Size parameters) {
    this.min = parameters.min();
    this.max = parameters.max();
  }

  // tag::adocSnippet[]
  public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
    if (charSequence == null) {
      return true;
    } else {
      int length = charSequence.length();
      return length >= this.min && length <= this.max;
    }
  }
  // end::adocSnippet[]
}
