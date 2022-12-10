package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

// @formatter:off
// tag::adocSnippet[]
public interface ConstraintValidator<A extends Annotation, T> {

  default void initialize(A constraintAnnotation) { }

  boolean isValid(T value, ConstraintValidatorContext context);
}
// end::adocSnippet[]
