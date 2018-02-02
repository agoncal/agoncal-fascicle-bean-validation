package org.agoncal.fascicle.beanvalidation.integrating.cdi;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ZipCodeChecker {

  public boolean isZipCodeValid(String zipcode) {
    // Call an external web service to check zipcode
    return true;
  }
}
