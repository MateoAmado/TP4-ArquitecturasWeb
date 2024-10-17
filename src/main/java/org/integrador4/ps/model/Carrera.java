package org.integrador4.ps.model;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Carrera")
@Table(name = "carrera")
@Getter
@Setter
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long idCarrera;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<Estudiante> estudiantes;

    public Carrera(String nombre) {
        this.nombre = nombre;
        estudiantes = new HashSet<>();
    }

    public Carrera() {}



    @Override
    public String toString() {
        return "Carrera '\n' " +
                "- idCarrera = " + idCarrera + '\n' +
                "- Nombre = " + nombre + '\n' +
                '.';
    }

    public void addEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
        }
    }
}
