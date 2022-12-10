package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex02;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Book {

  @NotNull
  private String title;
  @Digits(integer = 4, fraction = 2)
  private Float price;
  @Size(max = 2000)
  private String description;
  private Integer isbn;
  @Positive
  private Integer nbOfPages;
  @Email
  private String authorEmail;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public Book() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getIsbn() {
    return isbn;
  }

  public void setIsbn(Integer isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public String getAuthorEmail() {
    return authorEmail;
  }

  public void setAuthorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
