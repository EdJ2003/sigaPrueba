package co.edu.unisabana.siga.controller;

import co.edu.unisabana.siga.bd.Estudiante;
import co.edu.unisabana.siga.controller.dto.Respuesta;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaludoController {

    List<Estudiante> listEstudiante= new ArrayList<>();

    public SaludoController(){

        listEstudiante.add(new Estudiante(1,"Eduen",20,true));
        listEstudiante.add(new Estudiante(2,"Daniel",32,true));
        listEstudiante.add(new Estudiante(3,"Daniela",16,false));
        listEstudiante.add(new Estudiante(4,"David",21,false));

    }

    @GetMapping(path = "/estudiante/busca/{id}")
    public Estudiante buscarEstudiantePorId(@PathVariable int id){

        for (Estudiante estudiante: listEstudiante){
            if (estudiante.getCodigo() == id){
                return estudiante;
            }
        }

        return null;
    }

    @GetMapping(path = "/estudiante")
    public List<Estudiante> filtrarEstudiantePorNombre(@RequestParam String nombre, @RequestParam int limite){

        List<Estudiante> filtro= new ArrayList<>();
        for (Estudiante estudiante: listEstudiante){
            if (estudiante.getNombre().contains(nombre) && filtro.size()<limite){
                filtro.add(estudiante);
            }
        }

        return filtro;
    }

    @GetMapping(path = "/estudiante/{nombre}/{limite}")
    public List<Estudiante> filtrarEstudiantePorNombre2(@PathVariable String nombre, @PathVariable int limite){

        List<Estudiante> filtro= new ArrayList<>();
        for (Estudiante estudiante: listEstudiante){
            if (estudiante.getNombre().contains(nombre) && filtro.size()<limite){
                filtro.add(estudiante);
            }
        }

        return filtro;
    }


    @PostMapping(path="/estudiante/agregar")
    public Respuesta agregarEstudiante(@RequestBody Estudiante estudiante){

        listEstudiante.add(estudiante);
        return new Respuesta("Ok");
    }
    boolean editar= false;
    @PutMapping(path="/estudiante/revivir/{id}")
    public Respuesta revivirEstudiante(@PathVariable int id){
        for(Estudiante estudiante: listEstudiante){
            if(estudiante.getCodigo() == id && !estudiante.isVivo()){
                estudiante.setVivo(true);
                editar= true;
                return new Respuesta("Revivido");
            }


        }
        if (!editar){
            return new Respuesta("Ya está revivido");
        }
        else{return new Respuesta("nada");}
    }

    @GetMapping("/saludame")
    public String saludar(){
        return "Hola mundo desde un servidor";
    }

    @GetMapping("/suma")
    public String sumar(@RequestParam int numero1,@RequestParam int numero2){
        return "Resultado "+(numero1+numero2);
    }

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public Respuesta eliminar(@PathVariable int id)
    {
        for (Estudiante estudiante: listEstudiante){
            if(estudiante.getCodigo() ==id){
                this.listEstudiante.remove(estudiante);
                this.editar= true;
                return new Respuesta("Estudiante eliminado");
            }



        }
        if(!editar){

        return new Respuesta("No se encontró al estudiante");
        }
        return null;
    }
}
