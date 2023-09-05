package co.edu.unisabana.siga.logica;

import co.edu.unisabana.siga.bd.Estudiante;
import co.edu.unisabana.siga.bd.EstudianteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudianteLogica {
    private EstudianteRepository estudianteRepository;

    public EstudianteLogica(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void guardarEstudiante(Estudiante estudiante){
        if("Daniel".equals(estudiante.getNombre())){
            throw new IllegalArgumentException("No se aceptan estudiantes con el nombre Daniel");
        }
        estudianteRepository.save(estudiante);
    }





}