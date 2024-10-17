package org.integrador4.ps.controller;

import org.integrador4.ps.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.integrador4.ps.model.Estudiante;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodasLosEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante e = estudianteService.guardarEstudiante(estudiante);
        return new ResponseEntity<Estudiante>(e, HttpStatus.CREATED);
    }

   @GetMapping("/nroLibreta/{nroLibreta}")
    public ResponseEntity<Estudiante> obtenerJugadoresNroLibreta(@PathVariable int nroLibreta) {
        int idLibreta = Integer.valueOf(nroLibreta);
        Estudiante e=estudianteService.getEstudiantePorNroLibreta(idLibreta);
        if(e!=null){
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Estudiante>> obtenerJugadoresGenero(@PathVariable String genero) {
        List<Estudiante> estudiantes=estudianteService.getEstudiantesPorGenero(genero);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesOrdenadosApellido(){
        List<Estudiante> estudiantes=estudianteService.getEstudiantesOrdenadorPorApellido();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @PutMapping("/{nroDocumento}")
    public Estudiante actualizarEstudiante(@PathVariable Long nroDocumento,
                                           @RequestBody Estudiante estudiante){
        estudianteService.actualizarEstudiante(nroDocumento, estudiante);
        return estudianteService.guardarEstudiante(estudiante);
    }

    @DeleteMapping("/{nroDocumento}")
    public void eliminarEstudiante(@PathVariable Long nroDocumento){
           estudianteService.eliminarEstudiante(nroDocumento);
    }

    @GetMapping("/FiltroCarreraYCiudad/{carrera}/{ciudad}")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorCarreraYCiudad(@PathVariable String carrera, @PathVariable String ciudad) {
        List<Estudiante> estudiantes=estudianteService.obtenerEstudiantesPorCarreraYCiudad(carrera, ciudad);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

}
