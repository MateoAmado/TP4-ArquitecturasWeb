package org.integrador3.ps.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "estudiante_carrera")
public class Estudiante_Carrera {

    @EmbeddedId
    private EstudianteCarreraId id;

    @ManyToOne
    @MapsId("estudianteNumeroDocumento")
    @JoinColumn(name = "estudiante_numero_documento")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("IdCarrera")
    @JoinColumn(name = "carrera_id_carrera")
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @Column(name="graduado")
    private boolean graduado = false;

    // Constructor, getters y setters

    public Estudiante_Carrera(){

    }

    public Estudiante_Carrera(EstudianteCarreraId id, Estudiante estudiante, Carrera carrera, LocalDate fechaInscripcion) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado = false;
    }

    public Estudiante_Carrera(EstudianteCarreraId id,Estudiante estudiante, Carrera carrera, LocalDate fecha, boolean graduado) {
        this.id=id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaInscripcion = fecha;
        this.graduado = graduado;
    }

    public EstudianteCarreraId getId() {
        return id;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean getGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Estudiante_Carrera{" +
                "id=" + id +
                ", estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", graduado=" + graduado +
                '}';
    }

    public void setId(EstudianteCarreraId id) {
        this.id=id;
    }
}
