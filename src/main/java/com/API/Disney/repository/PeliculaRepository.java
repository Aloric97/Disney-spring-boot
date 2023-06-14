package com.API.Disney.repository;

import com.API.Disney.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
