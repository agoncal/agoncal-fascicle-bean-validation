package org.agoncal.fascicle.beanvalidation.integrating.jpa;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateAValidBook() throws Exception {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("beanvalidationPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    // Creates an instance of book
    Book book = new Book().title("H2G2").description("The Hitchhiker's Guide to the Galaxy").price(12.5F).isbn("1-84023-742-2").nbOfPages(354);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull(book.getId(), "ID should not be null");

    em.close();
  }

  @Test
  public void shouldRaiseConstraintViolationCauseNullTitle() {

    // tag::shouldRaiseConstraintViolationCauseNullTitle[]
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("beanvalidationPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    Book book = new Book().title(null).price(12.5F).isbn("1-84023-742-2").nbOfPages(354);
    assertThrows(RollbackException.class, () -> {
      tx.begin();
      em.persist(book);
      tx.commit();
    });
    // end::shouldRaiseConstraintViolationCauseNullTitle[]
  }
}
