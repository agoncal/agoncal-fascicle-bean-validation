package org.agoncal.fascicle.beanvalidation.writingconstraints.ex07;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
public class CD extends Item {

  @Pattern(regexp = "[A-Z][a-z]{1,}", message = "{music.company}")
  private String musicCompany;
  @Max(value = 5, message = "{number.cds}")
  private Integer numberOfCDs;
  private Float totalDuration;
  @MusicGenre
  private String genre;

  // ConstraintDeclarationException: not allowed when method overriding
  // public Float calculatePrice(@DecimalMin("1.4") Float rate) {
  //   return price * rate;
  // }

  // tag::adocskip[]
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

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public Integer getNumberOfCDs() {
    return numberOfCDs;
  }

  public void setNumberOfCDs(Integer numberOfCDs) {
    this.numberOfCDs = numberOfCDs;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
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
  // end::adocskip[]
}
// end::adocsnippet[]
