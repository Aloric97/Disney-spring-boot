package com.API.Disney.repository;

import com.API.Disney.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Long> {

    @Query("select e.nombre from personaje e")
    List<Personaje> findByNombre(Personaje personaje);
}
