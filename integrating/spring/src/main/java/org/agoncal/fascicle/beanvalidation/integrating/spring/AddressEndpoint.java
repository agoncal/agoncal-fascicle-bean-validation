package org.agoncal.fascicle.beanvalidation.integrating.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

// tag::adocSnippet[]
@RestController
public class AddressEndpoint {

    private final AddressRepository addressRepository;

    public AddressEndpoint(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) throws URISyntaxException {
        Address result = addressRepository.save(address);
        return ResponseEntity.created(new URI("/api/addresss/" + address.getId())).body(result);
    }
}
// end::adocSnippet[]
