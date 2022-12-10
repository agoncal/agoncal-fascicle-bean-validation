package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validate that the object is not {@code null}.
 *
 * @author Emmanuel Bernard
 */
// tag::adocSnippet[]
public class SizeValidatorForCharSequence implements ConstraintValidator<Size, CharSequence> {
  private int min;
  private int max;

  @Override
  public void initialize(Size parameters) {
    this.min = parameters.min();
    this.max = parameters.max();
  }

  // tag::adocIsValid[]
  @Override
  public boolean isValid(CharSequence charSequence, ConstraintValidatorContext ctx) {
    if (charSequence == null) {
      return true;
    } else {
      int length = charSequence.length();
      return length >= this.min && length <= this.max;
    }
    // end::adocIsValid[]
  }
  // end::adocSnippet[]
}
