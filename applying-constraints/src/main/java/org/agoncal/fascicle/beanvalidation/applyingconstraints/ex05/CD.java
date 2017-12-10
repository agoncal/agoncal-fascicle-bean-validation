package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex05;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class CD {

  @NotNull
  private String title;
  private String musicCompany;

  @NotEmpty @Size(max = 5)
  private Map<@Positive Integer, @NotBlank String> tracks;

  // tag::adocSkip[]
  // @formatter:on

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

  public void addTrack(Integer position, String title) {
    if (tracks == null)
      tracks = new HashMap<>();

    tracks.put(position, title);
  }

  // end::adocSkip[]
}
// end::adocSnippet[]

