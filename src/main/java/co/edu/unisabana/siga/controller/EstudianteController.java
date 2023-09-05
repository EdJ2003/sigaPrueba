package co.edu.unisabana.siga.controller;

import co.edu.unisabana.siga.bd.EstudianteRepository;
import co.edu.unisabana.siga.bd.Estudiante;
import co.edu.unisabana.siga.logica.EstudianteLogica;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteController {


    private EstudianteLogica estudianteLogica;


    public EstudianteController(EstudianteLogica estudianteRepository) {
        this.estudianteLogica = estudianteRepository;
    }

  /*  @GetMapping("/estudiantes")
    public List<Estudiante> obtenerEstudiante(){

        return estudianteLogica.findAll();
    }
*/


    @PostMapping ("/estudiantes/agregar")
    public String agregarEstudiante(@RequestBody Estudiante estudiante){
        estudianteLogica.guardarEstudiante(estudiante);

        return "Guardado";
    }

     /*
    @DeleteMapping("/estudiantes/agregar")
    public String eliminarEstudiante(){
        estudianteRepository.deleteAll();

        return "xiao xiao";
    }
*/
}
