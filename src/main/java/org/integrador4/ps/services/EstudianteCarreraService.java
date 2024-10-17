package org.integrador4.ps.services;

import org.integrador4.ps.dto.EstudianteCarreraDTO;
import org.integrador4.ps.dto.InformeCarreraDTO;
import org.integrador4.ps.model.Estudiante_Carrera;
import org.integrador4.ps.repository.EstudianteCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteCarreraService {

    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;


    public EstudianteCarreraDTO save(Estudiante_Carrera estudianteCarrera){
        if((estudianteCarrera.getEstudiante().getNumeroDocumento().equals(estudianteCarrera.getId().getEstudianteNumeroDocumento())) &&
                (estudianteCarrera.getCarrera().getIdCarrera().equals(estudianteCarrera.getId().getIdCarrera()))) {
            Estudiante_Carrera ec = this.estudianteCarreraRepository.save(estudianteCarrera);
            EstudianteCarreraDTO ecDTO = this.estudianteCarreraRepository.getEstudianteCarreraPorId(ec.getId());
            return ecDTO;
        }
        return null;
    }

    public List<EstudianteCarreraDTO> obtenerTodasLasCarrerasConEstudiantes() {
       List<EstudianteCarreraDTO> ec=estudianteCarreraRepository.getTodasLasCarrerasConEstudiantes();
        return ec;

    }

    public List<InformeCarreraDTO> obtenerInformeDTO() {
        List<InformeCarreraDTO> ec=estudianteCarreraRepository.obtenerInforme();
        return ec;
    }
}
