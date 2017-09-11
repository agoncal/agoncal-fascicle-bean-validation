package org.agoncal.fascicle.beanvalidation.writingconstraints.ex08;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Constraint(validatedBy = {URLValidator.class})
@ReportAsSingleViolation
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface URL {

  String message() default "Malformed URL";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String protocol() default "";

  String host() default "";

  int port() default -1;
}
