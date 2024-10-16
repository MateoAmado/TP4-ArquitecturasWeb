package org.integrador3.ps.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "estudiante")
@Data
public class Estudiante {

    @Id
    @Column(name = "numero_documento", unique = true)
    private Long numeroDocumento;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero", length = 100)
    private String genero;

    @Column(name = "ciudad_residencia", length = 100)
    private String ciudadResidencia;

    @Column(name = "numero_libreta_universitaria", unique = true)
    private int numeroLibretaUniversitaria;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiante_carrera",
            joinColumns = @JoinColumn(name = "estudiante_numero_documento"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id_carrera")
    )
    @JsonIgnore
    private Set<Carrera> carreras = new HashSet<>();

    public Estudiante(Long numeroDocumento, String nombre, String apellido, int edad, String genero, String ciudadResidencia, int numeroLibretaUniversitaria) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public Estudiante(){

    }

    public void setCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    @Override
    public String toString() {
        return "Estudiante " +'\n'+
                "- Numero de documento = " + numeroDocumento +'\n'+
                "- Nombre = " + nombre +'\n'+
                "- Apellido = " + apellido + '\n' +
                "- Edad = " + edad +'\n'+
                "- Genero = " + genero + '\n' +
                "- Ciudad de residencia = " + ciudadResidencia + '\n' +
                "- Numero de libreta universitaria = " + numeroLibretaUniversitaria +'\n'+
                '.';
    }
}
