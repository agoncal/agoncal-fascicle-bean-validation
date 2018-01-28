package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

  private static ValidatorFactory vf;
  private static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  static void init() {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterAll
  static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldTestOptional() {
    // tag::shouldTestOptional[]
    assertTrue(Optional.ofNullable("contains a value").isPresent());
    assertFalse(Optional.ofNullable(null).isPresent());
    // tag::shouldTestOptional[]
  }

  @Test
  void shouldRaiseNoConstraintViolation() {

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
  void shouldRaiseViolationDueToEmail() {

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
  void shouldRaiseNoConstraintViolationWithOptionalEmail() {

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
  void shouldRaiseViolationDueToNbPages() {

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
  void shouldRaiseNoConstraintViolationWithOptionalNbPages() {

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
  void shouldRaiseNoConstraintViolationWithNullTitle() {

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
