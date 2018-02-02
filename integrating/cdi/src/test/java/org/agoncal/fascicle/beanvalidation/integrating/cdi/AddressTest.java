package org.agoncal.fascicle.beanvalidation.integrating.cdi;

import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Disabled
@EnableWeld
public class AddressTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Validator validator;

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() {

    // tag::shouldRaiseNoConstraintViolation[]
    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");

    Set<ConstraintViolation<Address>> violations = validator.validate(address);
    assertEquals(0, violations.size());
    // end::shouldRaiseNoConstraintViolation[]
  }

  @Test
  public void shouldRaiseConstraintViolationCauseInvalidZipCode() {

    // tag::shouldRaiseConstraintViolationCauseInvalidZipCode[]
    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("DummyZip").country("USA");

    Set<ConstraintViolation<Address>> violations = validator.validate(address);
    assertEquals(1, violations.size());
    // end::shouldRaiseConstraintViolationCauseInvalidZipCode[]
  }
}
