package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// @formatter:off
// tag::adocSnippet[]
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Repeatable(Size.List.class)
@Documented
public @interface Size {

  String message() default "{javax.validation.constraints.Size.message}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  int min() default 0;
  int max() default Integer.MAX_VALUE;

  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @Documented
  @interface List {
    Size[] value();
  }
}
// end::adocSnippet[]
