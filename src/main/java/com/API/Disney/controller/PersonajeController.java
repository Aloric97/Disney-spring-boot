package com.API.Disney.controller;


import com.API.Disney.dto.PersonajeDTO;
import com.API.Disney.entity.Personaje;
import com.API.Disney.exception.RequestException;
import com.API.Disney.repository.interfaces.PersonajeProyection;
import com.API.Disney.service.imp.PersonajeServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeServiceImp personajeServiceImp;


    @GetMapping("/personaje/{id_personaje}")
    public ResponseEntity<Personaje> getPersonajeById(@PathVariable ("id_personaje") Long id_personaje){
        Optional<Personaje> findPersonaje= personajeServiceImp.getPersonajeById(id_personaje);

        if (findPersonaje.isPresent()){
            return ResponseEntity.ok(findPersonaje.get());
        } else{
            throw new RequestException("p-401","personaje id not found");
        }
    }


    @PostMapping(value = "/personaje", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<PersonajeDTO> savePersonaje(@RequestBody @Valid PersonajeDTO personaje ){
        personajeServiceImp.savePersonaje(personaje);
        return new ResponseEntity<>(personaje,HttpStatus.CREATED);
    }

    @GetMapping("/personajes")
    public ResponseEntity<List<Personaje>> getAllPersonaje(
         @RequestParam(value = "nombre",required = false) String nombre,
         @RequestParam(value = "edad",required = false) Integer edad )
    {
        List<Personaje> personajes;

        if ( nombre != null) {
            personajes=  personajeServiceImp.findByName(nombre);
        } else if ( edad !=null){
            personajes=personajeServiceImp.findByEdad(edad);
        } else {
            personajes=personajeServiceImp.getAllPersonaje();
        }
        return ResponseEntity.ok(personajes);
    }

    @GetMapping("/nameImagen")
    public ResponseEntity<List<PersonajeProyection>> getAllByNameImagen(){
        List<PersonajeProyection> personajes= personajeServiceImp.GetAllByNameAndImagen();

        return ResponseEntity.ok(personajes);
    }


    @PostMapping(value = "/addPelicula", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Personaje> addPeliculaEnPersonaje(Long id_personaje, Long id_pelicula){
        personajeServiceImp.addPeliculaEnPersonaje(id_personaje,id_pelicula);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
