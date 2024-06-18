/*
 * ---------------------------------------------
 * Author: Jay Christopher A Anacio
 * Date:   Monday June 17th 2024
 * Last Modified by: Jay Christopher A Anacio - <jcaanacio@gmail.com>
 * Last Modified time: June 17th 2024, 1:25:23 pm
 * ---------------------------------------------
 */


package com.sandari.rain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sandari.rain.libraries.exceptions.RestException;
import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.mappers.CsrfDto;



 @Service
 public class DemoService extends AbstractService {
    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings({ "deprecation" })
    public CsrfDto upstream(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RestException("External API call failed with status code: " + response.getStatusCodeValue(), 503, ErrorScope.SERVER);
        }

        String contentType = response.getHeaders().getContentType().toString();

        if (contentType.contains("text/html")) {
            String responseBody = response.getBody();
            System.out.println("Response Body (HTML): " + responseBody);
            throw new RestException("Expected JSON response but received HTML", 503, ErrorScope.SERVER);
        }

        ResponseEntity<CsrfDto> csrfResponse = restTemplate.getForEntity(url, CsrfDto.class);
        return csrfResponse.getBody();
     }

 }
