package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Size(min = 7)
@Pattern(regexp = "[a-f]{1,}")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE, ANNOTATION_TYPE, CONSTRUCTOR})
@Documented
public @interface Isbn {

  String message() default "Invalid ISBN number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
