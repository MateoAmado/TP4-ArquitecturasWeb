package org.integrador4.ps.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class EstudianteCarreraId implements Serializable {

    @Column(name = "estudiante_numero_documento")
    private Long estudianteNumeroDocumento;

    @Column(name = "id_carrera")
    private Long IdCarrera;

    public EstudianteCarreraId(Long estudianteNumeroDocumento, Long idCarrera){
        this.estudianteNumeroDocumento = estudianteNumeroDocumento;
        IdCarrera = idCarrera;
    }

    public EstudianteCarreraId() {

    }

    public Long getEstudianteNumeroDocumento() {
        return estudianteNumeroDocumento;
    }

    public void setEstudianteNumeroDocumento(Long estudianteNumeroDocumento) {
        this.estudianteNumeroDocumento = estudianteNumeroDocumento;
    }

    public Long getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        IdCarrera = idCarrera;
    }

    @Override
    public String toString() {
        return "EstudianteCarreraId{" +
                "estudianteNumeroDocumento=" + estudianteNumeroDocumento +
                ", IdCarrera=" + IdCarrera +
                '}';
    }
}
