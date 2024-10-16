package org.integrador3.ps.services;

import org.integrador3.ps.dto.CarreraInscriptosDTO;
import org.integrador3.ps.model.Carrera;
import org.integrador3.ps.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraRepository.obtenerTodasLasCarreras();
    }


    public Carrera guardarCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public List<Carrera> obtenerPorNombre(String nombre){
        return carreraRepository.findCarrerasPorNombre(nombre);
    }

    public void actualizarCarrera(Long id, Carrera carrera){
        carrera.setIdCarrera(id);
    }

    public List<CarreraInscriptosDTO> obtenerEstudiantesInscriptos() {
        return carreraRepository.obtenerEstudiantesInscriptos();
    }

    public void eliminarCarrera(Long id) {
        carreraRepository.deleteById(id);
    }
}
