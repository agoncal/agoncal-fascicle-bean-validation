package org.agoncal.fascicle.beanvalidation.writingconstraints.ex05;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class URLValidator implements ConstraintValidator<URL, String> {

  private String protocol;
  private String host;
  private int port;

  public void initialize(URL url) {
    this.protocol = url.protocol();
    this.host = url.host();
    this.port = url.port();
  }

  // tag::adocSnippet[]
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.length() == 0) {
      return true;
    }

    java.net.URL url;
    try {
      url = new java.net.URL(value);
    } catch (MalformedURLException e) {
      return false;
    }

    if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol)) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Invalid protocol").addConstraintViolation();
      return false;
    }

    if (host != null && host.length() > 0 && !url.getHost().startsWith(host)) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Invalid host").addConstraintViolation();
      return false;
    }

    if (port != -1 && url.getPort() != port) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Invalid port").addConstraintViolation();
      return false;
    }

    return true;
  }
  // end::adocSnippet[]
}
