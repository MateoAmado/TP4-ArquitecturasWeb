package org.integrador3.ps.dto;

import jakarta.persistence.*;
import org.integrador3.ps.model.Carrera;
import org.integrador3.ps.model.Estudiante;
import org.integrador3.ps.model.EstudianteCarreraId;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class EstudianteCarreraDTO {

    private EstudianteDTO estudianteDTO;
    private CarreraDTO carreraDTO;
    private LocalDate fechaInscripcion;
    private boolean graduado;


    public EstudianteCarreraDTO(EstudianteDTO estudiante,CarreraDTO carrera, LocalDate fechaInscripcion, boolean graduado) {
        this.carreraDTO = carrera;
        this.estudianteDTO = estudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado=graduado;
    }

    public EstudianteDTO getEstudianteDTO() {
        return estudianteDTO;
    }

    public CarreraDTO getCarreraDTO() {
        return carreraDTO;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public boolean isGraduado() {
        return graduado;
    }
}
