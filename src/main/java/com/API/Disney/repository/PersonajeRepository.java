package com.API.Disney.repository;

import com.API.Disney.entity.Pelicula;
import com.API.Disney.entity.Personaje;
import com.API.Disney.repository.interfaces.PersonajeProyection;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
    List<PersonajeProyection> findAllBy();

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(Integer edad);

    //consultas personalizadas
    @Query("SELECT p FROM Personaje p where p.edad>17 ")
    List<Personaje> getMayoresEdad();
}
