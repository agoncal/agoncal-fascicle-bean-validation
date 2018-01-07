package org.agoncal.fascicle.beanvalidation.integrating.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

// @formatter:off
// tag::adocSnippet[]
@Entity
public class Book {

  @Id @GeneratedValue
  private Long id;
  @NotNull
  private String title;
  @Digits(integer = 4, fraction = 2)
  private Float price;
  @Size(max = 2000)
  private String description;
  private String isbn;
  @Positive
  private Integer nbOfPages;
  @Email
  private String authorEmail;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Book id(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Book price(Float price) {
    this.price = price;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Book description(String description) {
    this.description = description;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public Book nbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
    return this;
  }

  public String getAuthorEmail() {
    return authorEmail;
  }

  public void setAuthorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
  }

  public Book authorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
