package org.integrador4.ps.Estudiante_Carrera.Repository;


import org.integrador4.ps.Estudiante_Carrera.DTO.EstudianteCarreraDTO;
import org.integrador4.ps.Estudiante_Carrera.DTO.InformeCarreraDTO;
import org.integrador4.ps.Estudiante_Carrera.Model.EstudianteCarreraId;
import org.integrador4.ps.Estudiante_Carrera.Model.Estudiante_Carrera;
import org.integrador4.ps.estudiantes_service.DTO.EstudianteDTO;
import org.integrador4.ps.estudiantes_service.model.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface EstudianteCarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {

 @Query("SELECT new org.integrador4.ps.Estudiante_Carrera.DTO.InformeCarreraDTO(c.idCarrera, c.nombre, e.numeroDocumento, e.nombre, e.apellido, e.ciudadResidencia, e.edad, e.genero, e.numeroLibretaUniversitaria, ec.fechaInscripcion, ec.graduado) " +
         "FROM Estudiante_Carrera ec " +
         "JOIN ec.estudiante e " +
         "JOIN ec.carrera c " +
         "ORDER BY ec.fechaInscripcion ASC, c.nombre ASC")
 public List<InformeCarreraDTO> obtenerInforme();


 @Query("SELECT e FROM Estudiante_Carrera ec JOIN ec.estudiante e WHERE ec.id = :id")
 EstudianteCarreraDTO getEstudianteCarreraPorId(@Param("id") EstudianteCarreraId id);


/*
 @Query("SELECT new org.integrador4.ps.Estudiante_Carrera.DTO.EstudianteCarreraDTO(" +
         "new org.integrador4.ps.estudiantes_service.DTO.EstudianteDTO(e.numeroDocumento, e.nombreEstudiante, e.apellidoEstudiante, e.edad, e.genero, e.ciudadResidencia, e.nroLibreta), " +
         "new org.integrador4.ps.carrera.dto.CarreraDTO(c.idCarrera, c.nombre), " +
         "ec.fechaInscripcion, ec.graduado) " +
         "FROM Estudiante_Carrera ec " +
         "JOIN ec.estudiante e " +
         "JOIN ec.carrera c")
 List<EstudianteCarreraDTO> getTodasLasCarrerasConEstudiantes();
*/





}