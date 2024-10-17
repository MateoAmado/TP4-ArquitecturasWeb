package org.integrador4.ps.dto;

public class EstudianteDTO {
    private Long numeroDocumento;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private int nroLibreta;

    public EstudianteDTO(Long numeroDocumento, String nombreEstudiante, String apellidoEstudiante, int edad,
                         String genero, String ciudadResidencia, int nroLibreta) {
        this.numeroDocumento = numeroDocumento;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibreta = nroLibreta;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public int getNroLibreta() {
        return nroLibreta;
    }
}
