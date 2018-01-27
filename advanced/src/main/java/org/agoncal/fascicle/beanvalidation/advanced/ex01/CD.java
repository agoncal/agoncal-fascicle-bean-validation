package org.agoncal.fascicle.beanvalidation.advanced.ex01;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class CD extends Item {

  @Pattern(regexp = "[A-Z][a-z]+")
  private String musicCompany;
  @Max(value = 5)
  private Integer numberOfCDs;
  private Float totalDuration;
  @MusicGenre
  private String genre;

  // ConstraintDeclarationException: not allowed when method overriding
  // public Float calculatePrice(@DecimalMin("1.4") Float rate) {
  //   return price * rate;
  // }
  // tag::adocSkip[]
  public CD() {
  }

  public CD(Long id, String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String genre) {
    super(id, title, price, description);
    this.musicCompany = musicCompany;
    this.numberOfCDs = numberOfCDs;
    this.totalDuration = totalDuration;
    this.genre = genre;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public CD id(Long id) {
    this.id = id;
    return this;
  }

  public CD title(String title) {
    this.title = title;
    return this;
  }

  public CD price(Float price) {
    this.price = price;
    return this;
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

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public CD genre(String genre) {
    this.genre = genre;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CD");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", musicCompany='").append(musicCompany).append('\'');
    sb.append(", numberOfCDs=").append(numberOfCDs);
    sb.append(", totalDuration=").append(totalDuration);
    sb.append(", genre='").append(genre).append('\'');
    sb.append('}');
    return sb.toString();
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
