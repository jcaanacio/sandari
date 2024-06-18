package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sandari.rain.Impl.DemoImpl;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.mappers.CsrfDtoTagalog;



@RestController
@RequestMapping("/api/v1/demo")
@Tag(name = "Demo Controller", description = "Controller for demo purposes")
public class DemoController {

    @Autowired
    private DemoImpl demoImpl;

    @Operation(summary = "Get CSRF Token", description = "Calls an external API to get a CSRF token")
    @GetMapping(value = "/upstream/{id}", produces = "application/json")
    public ResponseEntity<RestResponse<CsrfDtoTagalog>> callExternalApi(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(new RestResponse<CsrfDtoTagalog>(true, demoImpl.upstream(id), 200), HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<RestResponse<String>> ping() throws Exception {
        return new ResponseEntity<>(new RestResponse<String>(true, "ping", 200 ), HttpStatus.OK);
    }
}
