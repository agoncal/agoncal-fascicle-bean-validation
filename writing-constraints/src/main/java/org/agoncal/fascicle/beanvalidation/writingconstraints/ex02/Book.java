package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Book {

  private String title;
  private Float price;
  @Isbn
  private String isbn;
  private Integer nbOfPages;

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =            Constructors            =
  // ======================================

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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
