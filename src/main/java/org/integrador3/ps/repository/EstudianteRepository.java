package org.integrador3.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.integrador3.ps.model.Estudiante;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e FROM Estudiante e")
    List<Estudiante> obtenerTodasLosEstudiantes();

    List<Estudiante> findByNombreContaining(String nombre);

    @Query("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria= :nro")
    Estudiante findEstudianteByNumeroLibretaUniversitaria(int nro);

    @Query("SELECT e FROM Estudiante e WHERE LOWER(e.genero)= LOWER(:genero)")
    List<Estudiante> getEstudianteByGenero(String genero);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido")
    List<Estudiante> getEstudianteOrdenadosPorApellido();

    @Query("SELECT e FROM Estudiante e JOIN e.carreras c WHERE LOWER(e.ciudadResidencia) = LOWER(:ciudad) AND LOWER(c.nombre) = LOWER(:carrera)")
    List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(String carrera, String ciudad);
}

