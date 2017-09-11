package org.agoncal.fascicle.beanvalidation.writingconstraints.ex04;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
public class ItemServerConnection {

  @URL
  private String resourceURL;
  @NotNull
  @URL(protocol = "http", host = "www.cdbookstore.com")
  private String itemURL;
  @URL(protocol = "ftp", port = 21)
  private String ftpServerURL;
  private Date lastConnectionDate;

  // Constructors, Getters & Setters
  // tag::adocskip[]

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

  public Date getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(Date lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
  // end::adocskip[]
}
// end::adocsnippet[]
