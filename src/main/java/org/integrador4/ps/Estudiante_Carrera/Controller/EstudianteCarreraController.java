package org.integrador4.ps.Estudiante_Carrera.Controller;

import org.integrador4.ps.Estudiante_Carrera.Model.Estudiante_Carrera;
import org.integrador4.ps.Estudiante_Carrera.services.EstudianteCarreraService;
import org.integrador4.ps.Estudiante_Carrera.DTO.InformeCarreraDTO;
import org.integrador4.ps.Estudiante_Carrera.DTO.EstudianteCarreraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante_carrera")
public class EstudianteCarreraController {

 @Autowired
 private EstudianteCarreraService estudianteCarreraService;

/*
 @GetMapping("/")
 public ResponseEntity<List<EstudianteCarreraDTO>> obtenerTodasLasCarrerasConEstudiantes() {
    List<EstudianteCarreraDTO> carreras = estudianteCarreraService.obtenerTodasLasCarrerasConEstudiantes();
    return new ResponseEntity<>(carreras, HttpStatus.OK);
 }
*/

 @PostMapping
 public ResponseEntity<EstudianteCarreraDTO> crearEstudianteCarrera(@RequestBody Estudiante_Carrera estudianteCarrera) {
  EstudianteCarreraDTO nuevoEstudianteCarrera = estudianteCarreraService.save(estudianteCarrera);
  if(nuevoEstudianteCarrera != null) {
   return ResponseEntity.ok(nuevoEstudianteCarrera);
  }
  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

 /*
 @GetMapping("/informe")
 public ResponseEntity<List<InformeCarreraDTO>> obtenerInforme(){
  List<InformeCarreraDTO> esDTO = estudianteCarreraService.obtenerInformeDTO();
  return ResponseEntity.ok(esDTO);
 }

  */
}
