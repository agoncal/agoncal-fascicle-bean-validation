package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * <p>
 * <p>
 * http://www.antoniogoncalves.org
 * --
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
    book.setTitle("title");
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    assertTrue(book.getNbOfPages().isPresent());
    assertTrue(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToEmail() {

    Book book = new Book();
    book.setTitle("title");
    book.setNbOfPages(10);
    book.setAuthorEmail("dummy");

    assertTrue(book.getNbOfPages().isPresent());
    assertTrue(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithOptionalEmail() {

    Book book = new Book();
    book.setTitle("title");
    book.setNbOfPages(10);
    book.setAuthorEmail(null);

    assertTrue(book.getNbOfPages().isPresent());
    assertFalse(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseViolationDueToNbPages() {

    Book book = new Book();
    book.setTitle("title");
    book.setNbOfPages(-10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    assertTrue(book.getNbOfPages().isPresent());
    assertTrue(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithOptionalNbPages() {

    Book book = new Book();
    book.setTitle("title");
    book.setNbOfPages(null);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    assertFalse(book.getNbOfPages().isPresent());
    assertTrue(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithNullTitle() {

    Book book = new Book();
    book.setTitle(null);
    book.setNbOfPages(10);
    book.setAuthorEmail("agoncal.fascicle@gmail.com");

    assertTrue(book.getNbOfPages().isPresent());
    assertTrue(book.getAuthorEmail().isPresent());

    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    assertEquals(0, violations.size());
  }

  private void displayConstraintViolations(Set<ConstraintViolation<Book>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
        "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
