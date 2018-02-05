package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex07;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Book {

  private String title;
  private Integer isbn;
  private Integer nbOfPages;
  private String authorEmail;

  public String getTitle() {
    return title;
  }

  public Integer getIsbn() {
    return isbn;
  }

  public Optional<@Positive Integer> getNbOfPages() {
    return Optional.ofNullable(nbOfPages);
  }

  public Optional<@Email String> getAuthorEmail() {
    return Optional.ofNullable(authorEmail);
  }

  // Setters
  // tag::adocSkip[]
  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsbn(Integer isbn) {
    this.isbn = isbn;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public void setAuthorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
  }

  public Book() {
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
