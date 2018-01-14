package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookTest {

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

    Book book = new Book();
    book.setIsbn("aaaaaaaa");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    displayConstraintViolations(violations);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseIsbnNull() {

    Book book = new Book();

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseIsbnTooLong() {

    Book book = new Book();
    book.setIsbn("abcdef123456789");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseIsbnWrongPattern() {

    Book book = new Book();
    book.setIsbn("12345");

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Book>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
