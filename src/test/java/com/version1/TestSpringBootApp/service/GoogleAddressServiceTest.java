package com.version1.TestSpringBootApp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoogleAddressServiceTest {

    @MockBean
    private GoogleAddressService googleAddressService;

    @Test
    public void testGoogle() {
        Mockito.when(googleAddressService.getAddressById(1)).thenReturn("1");
        assertEquals("1", googleAddressService.getAddressById(1));
    }

    @Test
    public void testGoogleNull() {
        Mockito.when(googleAddressService.getAddressById(100)).thenReturn(null);
        assertNull(googleAddressService.getAddressById(100));
    }

    @Test
    public void testGoogleException() {
        Mockito.when(googleAddressService.getAddressById(1)).thenThrow(new RestClientException("Error"));
        assertEquals("Empty String", googleAddressService.getAddressById(1));
    }

}