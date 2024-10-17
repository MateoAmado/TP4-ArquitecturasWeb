package org.integrador4.ps.dto;

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
