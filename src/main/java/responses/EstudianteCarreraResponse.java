package responses;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.integrador3.ps.model.Estudiante_Carrera;

import java.util.List;

@NoArgsConstructor
public class EstudianteCarreraResponse{
    List<Estudiante_Carrera> estudiantes_carreras;
    public EstudianteCarreraResponse(List<Estudiante_Carrera> estudiantes_carreras) {
        this.estudiantes_carreras = estudiantes_carreras;
    }

    public List<Estudiante_Carrera> getEstudiantes_carreras() {
        return estudiantes_carreras;
    }

    public void setEstudiantes_carreras(List<Estudiante_Carrera> estudiantes_carreras) {
        this.estudiantes_carreras = estudiantes_carreras;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerTodasLasCarrerasConEstudiantes() {
        try {
            EstudianteCarreraResponse jr = new EstudianteCarreraResponse();
            return ResponseEntity.ok(jr);
        } catch (Exception e) {
            ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
        }
    }


}
