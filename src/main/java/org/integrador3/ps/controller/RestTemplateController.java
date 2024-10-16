package org.integrador3.ps.controller;


import org.integrador3.ps.model.Carrera;
import org.integrador3.ps.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.integrador3.ps.model.*;
import org.integrador3.ps.services.*;

@RestController
@RequestMapping("/rest_template")
public class RestTemplateController {

    @Autowired
    private ApiService api_service;

    @GetMapping
    public ResponseEntity<String> get() {
        return this.api_service.get();
    }

    @PostMapping
    public ResponseEntity<Carrera> post(@RequestBody Carrera carrera) {
        return this.api_service.post(carrera);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.api_service.delete(id);
    }
}
