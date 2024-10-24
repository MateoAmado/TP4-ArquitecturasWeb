package org.integrador4.ps.carrera.Controller;

import org.integrador4.ps.carrera.Service.Service;
import org.integrador4.ps.carrera.dto.CarreraInscriptosDTO;
import org.integrador4.ps.carrera.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class Controller {

    @Autowired
    private Service carreraService;

    @GetMapping("/")
    public ResponseEntity<List<Carrera>> obtenerTodasLasCarreras() {
        List<Carrera> carreras = carreraService.obtenerTodasLasCarreras();
        return new ResponseEntity<>(carreras, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Carrera> crearCarrera(@RequestBody Carrera carrera) {
        Carrera c = carreraService.guardarCarrera(carrera);
        return new ResponseEntity<Carrera>(c, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Carrera updateCarrera(@PathVariable Long id, @RequestBody Carrera carrera){
        carreraService.actualizarCarrera(id, carrera);
        return carreraService.guardarCarrera(carrera);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Carrera>> obtenerPorNombre(@PathVariable String nombre){
        List<Carrera> carreras = carreraService.obtenerPorNombre(nombre.toLowerCase());
        return new ResponseEntity<>(carreras, HttpStatus.OK);
    }

    //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/Estudiantes_inscriptos")
    public ResponseEntity<List<CarreraInscriptosDTO>> obtenerEstudiantesInscriptos(){
        List<CarreraInscriptosDTO> carreras = carreraService.obtenerEstudiantesInscriptos();
        return new ResponseEntity<>(carreras, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Long id){
        carreraService.eliminarCarrera(id);
    }

}
