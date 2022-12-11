package org.agoncal.fascicle.beanvalidation.integrating.spring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the AddressResource REST controller.
 *
 * @see AddressEndpoint
 */
@SpringBootTest(classes = BVSpringApplication.class)
public class AddressEndpointTest {

  @Autowired
  private AddressRepository addressRepository;

  private MockMvc mockAddressEndpoint;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    final AddressEndpoint addressEndpoint = new AddressEndpoint(addressRepository);
    this.mockAddressEndpoint = MockMvcBuilders.standaloneSetup(addressEndpoint).build();
  }

  @Test
  @Transactional
  public void createValidAddress() throws Exception {

    // tag::createValidAddress[]
    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");

    mockAddressEndpoint.perform(post("/addresses")
      .contentType("application/json")
      .content(convertObjectToJsonBytes(address)))
      .andExpect(status().isCreated());
    // end::createValidAddress[]
  }

  @Test
  @Transactional
  public void createInvalidAddress() throws Exception {

    // tag::createInvalidAddress[]
    Address address = new Address().street1(null).city("New York").state("NY").zipcode("12345").country("USA");

    mockAddressEndpoint.perform(post("/addresses")
      .contentType("application/json")
      .content(convertObjectToJsonBytes(address)))
      .andExpect(status().isBadRequest());
    // end::createInvalidAddress[]
  }

  public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    JavaTimeModule module = new JavaTimeModule();
    mapper.registerModule(module);

    return mapper.writeValueAsBytes(object);
  }
}
