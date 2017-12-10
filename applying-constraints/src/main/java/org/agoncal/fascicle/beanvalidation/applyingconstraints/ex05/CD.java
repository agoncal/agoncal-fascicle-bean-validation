package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex05;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class CD {

  @NotNull
  private String title;
  private String musicCompany;

  private Map<@Positive Integer, @NotBlank String> tracks;

  // tag::adocSkip[]

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD() {
  }

  public CD(String title, String musicCompany) {
    this.title = title;
    this.musicCompany = musicCompany;
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

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public Map<Integer, String> getTracks() {
    return tracks;
  }

  public void setTracks(Map<Integer, String> tracks) {
    this.tracks = tracks;
  }


  // end::adocSkip[]
}
// end::adocSnippet[]

