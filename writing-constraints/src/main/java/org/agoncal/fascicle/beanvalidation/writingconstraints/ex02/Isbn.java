package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// tag::adocSnippet[]
@Constraint(validatedBy = {})

@NotNull
@Size(min = 7)
@Pattern(regexp = "[a-f]{1,}")
@ReportAsSingleViolation

@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE, ANNOTATION_TYPE, CONSTRUCTOR})
@Documented
public @interface Isbn {

  String message() default "Invalid ISBN number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
// end::adocSnippet[]
