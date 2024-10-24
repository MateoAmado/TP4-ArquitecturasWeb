package org.integrador4.ps.carrera.Service;

import org.integrador4.ps.carrera.repository.Repository;
import org.integrador4.ps.carrera.dto.CarreraInscriptosDTO;
import org.integrador4.ps.carrera.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository carreraRepository;

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
