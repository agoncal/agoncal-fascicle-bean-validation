package org.agoncal.fascicle.beanvalidation.advanced.ex01;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Pattern(regexp = "[A-Z][a-z]{1,}")
@Size(min = 3, max = 20)
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MusicGenre {

  String message() default "{music.genre}";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
