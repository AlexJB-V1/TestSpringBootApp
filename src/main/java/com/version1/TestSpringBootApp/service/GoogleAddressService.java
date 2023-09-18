package com.version1.TestSpringBootApp.service;

import com.version1.TestSpringBootApp.model.HandleCode;
import com.version1.TestSpringBootApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class GoogleAddressService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PersonFactory personFactory;


    public String getAddressById(int addressId) {
        try {
            return restTemplate.getForObject("someurl" + addressId, String.class);
        } catch (RestClientException ex) {
            System.out.println("Did reach here");
            personFactory.returnService(HandleCode.PRINT);
        }
        return "Empty String";
    }

}
