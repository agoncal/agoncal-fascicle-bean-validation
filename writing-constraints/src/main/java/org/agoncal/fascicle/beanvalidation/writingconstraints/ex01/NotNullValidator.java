package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

/**
 * Validate that the object is not {@code null}.
 *
 * @author Emmanuel Bernard
 */
// tag::adocSnippet[]
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

  @Override
  public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
    return object != null;
  }
}
// end::adocSnippet[]
