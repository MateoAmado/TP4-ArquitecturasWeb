package org.integrador4.ps.dto;

public class CarreraDTO {

    private Long idCarrera;
    private String nombreCarrera;

    public CarreraDTO(Long idCarrera, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }
}
