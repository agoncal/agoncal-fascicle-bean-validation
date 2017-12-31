package org.agoncal.fascicle.beanvalidation.validatingconstraints.ex01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CDTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  public static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() {

    // tag::shouldRaiseNoConstraintViolation[]
    CD cd = new CD().title("Kind of Blue").price(12.5f);

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintViolation[]
  }

  @Test
  public void shouldRaiseConstraintViolationCauseTitleAndPriceAreNull() {

    // tag::shouldRaiseConstraintViolationCauseTitleAndPriceAreNull[]
    CD cd = new CD();

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintViolationCauseTitleAndPriceAreNull[]
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty() {

    // tag::shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty[]
    CD cd = new CD().numberOfCDs(2);

    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty[]
  }

  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  public void shouldRaiseConstraintViolationValidatingNumberOfCDsProperty() {

    // tag::shouldRaiseConstraintViolationValidatingNumberOfCDsProperty[]
    CD cd = new CD().numberOfCDs(7);

    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");

    assertEquals(1, violations.size());
    ConstraintViolation<CD> violation = violations.iterator().next();

    assertEquals("must be less than or equal to 5", violation.getMessage());
    assertEquals(7, violation.getInvalidValue());
    assertEquals("{javax.validation.constraints.Max.message}", violation.getMessageTemplate());
    // end::shouldRaiseConstraintViolationValidatingNumberOfCDsProperty[]
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD>> violations;
    // tag::shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue[]
    violations = validator.validateValue(CD.class, "numberOfCDs", 2);
    assertEquals(0, violations.size());

    violations = validator.validateValue(CD.class, "numberOfCDs", 7);
    assertEquals(1, violations.size());
    // end::shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue[]
  }

  @Test
  public void shouldRaiseNoMethodParameterConstraintViolation() throws NoSuchMethodException {

    // tag::shouldRaiseNoMethodParameterConstraintViolation[]
    CD cd = new CD().title("Kind of Blue").price(12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(1.2)});
    assertEquals(1, violations.size());
    // end::shouldRaiseNoMethodParameterConstraintViolation[]
  }

  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  public void shouldRaiseMethodParameterConstraintViolationCauseRateIsLow() throws NoSuchMethodException {

    CD cd = new CD().title("Kind of Blue").price(12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(1.2)});
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("must be greater than or equal to 1.4", violations.iterator().next().getMessage());
    assertEquals(new Float(1.2), violations.iterator().next().getInvalidValue());
    assertEquals("{javax.validation.constraints.DecimalMin.message}", violations.iterator().next().getMessageTemplate());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithGroup() {

    CD cd = new CD().title("Kind of Blue").price(12.5f).description("Best Jazz CD ever");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithGroupEvenWithNullTitleAndPrice() {

    CD cd = new CD().description("Best Jazz CD ever");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitleAndPrice() {

    // tag::shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitleAndPrice[]
    CD cd = new CD().description("Best Jazz CD ever");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class);
    assertEquals(2, violations.size());
    // end::shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitleAndPrice[]
  }

  @Test
  public void shouldRaiseConstraintViolationWithNoGroupsCauseNullTitleAndPrice() {

    CD cd = new CD().description("Best Jazz CD ever");

    // tag::shouldRaiseConstraintViolationWithNoGroupsCauseNullTitleAndPrice[]
    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    // end::shouldRaiseConstraintViolationWithNoGroupsCauseNullTitleAndPrice[]
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithDefaultGroupCauseNullTitleAndPrice() {

    CD cd = new CD().description("Best Jazz CD ever");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitlePriceAndSize() {

    // tag::shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitlePriceAndSize[]
    CD cd = new CD().description("Jazz");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class);
    assertEquals(3, violations.size());
    // end::shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitlePriceAndSize[]
  }

  @Test
  public void shouldRaiseConstraintViolationWithOneGroupCauseSize() {

    // tag::shouldRaiseConstraintViolationWithOneGroupCauseSize[]
    CD cd = new CD().description("Too short");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintViolationWithOneGroupCauseSize[]
  }

  @Test
  public void shouldRaiseConstraintViolationWithGroupCauseSizeIsShort() {

    CD cd = new CD().title("Kind of Blue").price(12.5f).description("Jazz");

    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
    assertEquals(1, violations.size());
  }


  private void displayContraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
