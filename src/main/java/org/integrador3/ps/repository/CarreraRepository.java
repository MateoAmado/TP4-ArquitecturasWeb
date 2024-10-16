package org.integrador3.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.integrador3.ps.model.Carrera;

import org.integrador3.ps.dto.CarreraInscriptosDTO;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c")
    List<Carrera> obtenerTodasLasCarreras();

    @Query("SELECT c FROM Carrera c WHERE LOWER(c.nombre) = LOWER(:nombre)")
    List<Carrera> findCarrerasPorNombre(String nombre);

    @Query("SELECT new org.integrador3.ps.dto.CarreraInscriptosDTO(c.idCarrera, c.nombre, COUNT(e)) " +
            "FROM Carrera c " +
            "JOIN c.estudiantes e " +
            "GROUP BY c.idCarrera, c.nombre " +
            "ORDER BY COUNT(e) DESC")
    List<CarreraInscriptosDTO> obtenerEstudiantesInscriptos();

}

