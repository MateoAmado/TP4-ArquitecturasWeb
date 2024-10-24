package org.integrador4.ps.carrera.response;

import lombok.NoArgsConstructor;
import org.integrador4.ps.carrera.model.Carrera;

import java.util.List;

@NoArgsConstructor
public class CarreraResponse {
    List<Carrera> carreras;
    public CarreraResponse(List<Carrera> estudiantes) {
        this.carreras = estudiantes;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

}
