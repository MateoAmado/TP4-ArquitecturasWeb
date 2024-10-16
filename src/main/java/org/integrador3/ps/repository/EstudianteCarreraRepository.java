package org.integrador3.ps.repository;

import org.integrador3.ps.dto.EstudianteCarreraDTO;
import org.integrador3.ps.dto.EstudianteDTO;
import org.integrador3.ps.dto.CarreraDTO;
import org.integrador3.ps.dto.InformeCarreraDTO;
import org.integrador3.ps.model.EstudianteCarreraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.integrador3.ps.model.Estudiante_Carrera;

import java.util.List;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {

   @Query("SELECT new org.integrador3.ps.dto.InformeCarreraDTO(c.idCarrera, c.nombre, e.numeroDocumento, e.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroLibretaUniversitaria, ec.fechaInscripcion, ec.graduado) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.estudiante e " +
            "JOIN  ec.carrera c " +
            "ORDER BY  ec.fechaInscripcion, c.nombre ASC")
    public List<InformeCarreraDTO> obtenerInforme();

    @Query("SELECT new org.integrador3.ps.dto.EstudianteCarreraDTO(" +
            "new org.integrador3.ps.dto.EstudianteDTO(e.numeroDocumento, e.nombre, e.apellido, e.edad, e.genero, e.ciudadResidencia, e.numeroLibretaUniversitaria), " +
            "new org.integrador3.ps.dto.CarreraDTO(c.idCarrera, c.nombre), " +
            "ec.fechaInscripcion, ec.graduado) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.estudiante e " +
            "JOIN ec.carrera c " +
            "WHERE ec.id=:id")

    EstudianteCarreraDTO getEstudianteCarreraPorId(EstudianteCarreraId id);


    @Query("SELECT new org.integrador3.ps.dto.EstudianteCarreraDTO(" +
            "new org.integrador3.ps.dto.EstudianteDTO(e.numeroDocumento, e.nombre, e.apellido, e.edad, e.genero, e.ciudadResidencia, e.numeroLibretaUniversitaria), " +
            "new org.integrador3.ps.dto.CarreraDTO(c.idCarrera, c.nombre), " +
            "ec.fechaInscripcion, ec.graduado) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.estudiante e " +
            "JOIN ec.carrera c")
    List<EstudianteCarreraDTO> getTodasLasCarrerasConEstudiantes();


}
