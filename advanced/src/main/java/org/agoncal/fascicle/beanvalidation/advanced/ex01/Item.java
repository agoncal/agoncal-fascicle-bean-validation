package org.agoncal.fascicle.beanvalidation.advanced.ex01;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Item {

  @NotNull
  protected Long id;
  @NotNull @Size(min = 4, max = 50)
  protected String title;
  protected Float price;
  protected String description;

  @NotNull
  public Float calculateVAT() {
    return price * 0.196f;
  }

  @NotNull
  public Float calculatePrice(@DecimalMin("1.2") Float rate) {
    return price * rate;
  }
  // tag::adocSkip[]
  // @formatter:on

  public Item() {
  }

  public Item(Long id, String title, Float price, String description) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Item");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append('}');
    return sb.toString();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
