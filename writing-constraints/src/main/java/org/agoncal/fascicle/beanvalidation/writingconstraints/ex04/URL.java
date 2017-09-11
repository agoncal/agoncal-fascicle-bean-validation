package org.agoncal.fascicle.beanvalidation.writingconstraints.ex04;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocsnippet[]
@Constraint(validatedBy = {URLValidator.class})
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
// end::adocsnippet[]
// @formatter:on
