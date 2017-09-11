package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

// tag::adocsnippet[]
public interface ConstraintValidator<A extends Annotation, T> {

  default void initialize(A constraintAnnotation) {
  }

  boolean isValid(T value, ConstraintValidatorContext context);
}
// end::adocsnippet[]
