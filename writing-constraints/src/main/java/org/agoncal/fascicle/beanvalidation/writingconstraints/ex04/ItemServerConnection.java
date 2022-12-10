package org.agoncal.fascicle.beanvalidation.writingconstraints.ex04;

import jakarta.validation.constraints.NotNull;
import java.time.Instant;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class ItemServerConnection {

  @URL
  private String resourceURL;
  @NotNull
  @URL(protocol = "http", host = "www.cdbookstore.com")
  private String itemURL;
  @URL(protocol = "ftp", port = 21)
  private String ftpServerURL;
  private Instant lastConnectionDate;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public ItemServerConnection() {
  }

  public ItemServerConnection(String resourceURL, String itemURL, String ftpServerURL) {
    this.resourceURL = resourceURL;
    this.itemURL = itemURL;
    this.ftpServerURL = ftpServerURL;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getResourceURL() {
    return resourceURL;
  }

  public void setResourceURL(String resourceURL) {
    this.resourceURL = resourceURL;
  }

  public String getItemURL() {
    return itemURL;
  }

  public void setItemURL(String itemURL) {
    this.itemURL = itemURL;
  }

  public String getFtpServerURL() {
    return ftpServerURL;
  }

  public void setFtpServerURL(String ftpServerURL) {
    this.ftpServerURL = ftpServerURL;
  }

  public Instant getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(Instant lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
