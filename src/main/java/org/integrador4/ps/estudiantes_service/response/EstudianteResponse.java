package org.integrador4.ps.estudiantes_service.response;


import lombok.NoArgsConstructor;
import org.integrador4.ps.estudiantes_service.model.Estudiante;

import java.util.List;

@NoArgsConstructor
public class EstudianteResponse {
    List<Estudiante> estudiantes;
    public EstudianteResponse(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> jugadores) {
        this.estudiantes = jugadores;
    }
}
