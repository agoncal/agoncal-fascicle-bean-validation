package org.agoncal.fascicle.beanvalidation.validatingconstraints.ex01;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class CD {

  // tag::adocAttributes[]
  @NotNull @Size(min = 4, max = 50)
  private String title;
  @NotNull @Positive
  private Float price;
  @Size(min = 10, max = 5000)
  private String description;
  @Pattern(regexp = "[A-Z][a-z]+")
  private String musicCompany;
  @Max(value = 5)
  private Integer numberOfCDs;
  private Float totalDuration;

  // end::adocAttributes[]
  // tag::adocMethodPrice[]
  @NotNull @DecimalMin("5.8")
  public Float calculatePrice(@DecimalMin("1.4") Float discountRate) {
    return price * discountRate;
  }

  // end::adocMethodPrice[]
  // tag::adocMethodVat[]
  @DecimalMin("9.99")
  public Float calculateVAT() {
    return price * 0.196f;
  }
  // end::adocMethodVat[]
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD() {
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

  public CD title(String title) {
    this.title = title;
    return this;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public CD price(Float price) {
    this.price = price;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CD description(String description) {
    this.description = description;
    return this;
  }

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public CD musicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
    return this;
  }

  public Integer getNumberOfCDs() {
    return numberOfCDs;
  }

  public void setNumberOfCDs(Integer numberOfCDs) {
    this.numberOfCDs = numberOfCDs;
  }

  public CD numberOfCDs(Integer numberOfCDs) {
    this.numberOfCDs = numberOfCDs;
    return this;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public CD totalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
    return this;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]

