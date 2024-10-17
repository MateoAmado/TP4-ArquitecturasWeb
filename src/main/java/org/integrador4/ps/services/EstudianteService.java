package org.integrador4.ps.services;

import org.integrador4.ps.model.Estudiante;
import org.integrador4.ps.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    public List<Estudiante> obtenerTodasLosEstudiantes() {
        return estudianteRepository.obtenerTodasLosEstudiantes();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    public Estudiante getEstudiantePorNroLibreta(int idLibreta) {
        Estudiante e=estudianteRepository.findEstudianteByNumeroLibretaUniversitaria(idLibreta);
        return e;
    }

    public List<Estudiante> getEstudiantesPorGenero(String genero) {
        List<Estudiante> estudiantes=estudianteRepository.getEstudianteByGenero(genero);
        return estudiantes;
    }

    public List<Estudiante> getEstudiantesOrdenadorPorApellido() {
        List<Estudiante> estudiantes=estudianteRepository.getEstudianteOrdenadosPorApellido();
        return estudiantes;
    }

    public void actualizarEstudiante(Long nroDocumento, Estudiante estudiante){
        estudiante.setNumeroDocumento(nroDocumento);


    }

    public List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(String carrera, String ciudad){
        return estudianteRepository.obtenerEstudiantesPorCarreraYCiudad(carrera, ciudad);
    }

    public void eliminarEstudiante(Long nroDocumento) {
        estudianteRepository.deleteById(nroDocumento);
    }
}
