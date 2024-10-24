package org.integrador4.ps.carrera.repository;

import org.integrador4.ps.carrera.dto.CarreraInscriptosDTO;
import org.integrador4.ps.carrera.model.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c")
    List<Carrera> obtenerTodasLasCarreras();

    @Query("SELECT c FROM Carrera c WHERE LOWER(c.nombre) = LOWER(:nombre)")
    List<Carrera> findCarrerasPorNombre(String nombre);

    @Query("SELECT new org.integrador4.ps.carrera.dto.CarreraInscriptosDTO(c.idCarrera, c.nombre, COUNT(e)) " +
            "FROM Carrera c " +
            "JOIN c.estudiantes e " +
            "GROUP BY c.idCarrera, c.nombre " +
            "ORDER BY COUNT(e) DESC")
    List<CarreraInscriptosDTO> obtenerEstudiantesInscriptos();

}
