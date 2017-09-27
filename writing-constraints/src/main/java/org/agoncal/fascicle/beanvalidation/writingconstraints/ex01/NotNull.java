package org.agoncal.fascicle.beanvalidation.writingconstraints.ex01;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// tag::adocSnippet[]
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NotNullValidator.class})
public @interface NotNull {

  String message() default "{javax.validation.constraints.NotNull.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
// end::adocSnippet[]
