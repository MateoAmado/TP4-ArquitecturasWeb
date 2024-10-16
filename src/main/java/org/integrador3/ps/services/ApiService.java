package org.integrador3.ps.services;

import org.integrador3.ps.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.integrador3.ps.model.*;


@Service
public class ApiService {
    // Reemplaza con la URL de tu API

    @Value("http://localhost:8090")
    private String base_url;

    @Autowired
    private RestTemplate rest_template;

    public ResponseEntity<String> get() {
        return this.rest_template.getForEntity(this.base_url, String.class);
    }

    public ResponseEntity<Carrera> post(Carrera carrera) {
        return this.rest_template.postForEntity(this.base_url, carrera, Carrera.class);
    }

    public void delete(Long id) {
        this.rest_template.delete(this.base_url + "/" + id);
    }

}
