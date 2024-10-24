package org.integrador4.ps.controller;


import org.integrador4.ps.carrera.model.Carrera;
import org.integrador4.ps.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
