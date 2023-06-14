package com.API.Disney.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pelicula;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "titulo")
    @NotNull(message = "The tile can't be null")
    private String titulo;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "calificacion")
    @Min(value = 1,message = "the rating can't be less than 1")
    @Max(value = 5,message = "The rating can't be higher than 5")
    private int calificacion;


    @JsonIgnore
    @ManyToMany(mappedBy = "peliculas")
    private List<Personaje> personajes;

    @ManyToOne()
    @JoinColumn(name = "id_genero")
    private  Genero genero;

    private Pelicula() {
    }

    public Pelicula(String imagen, String titulo, LocalDate fechaCreacion, int calificacion, List<Personaje> personajes, Genero genero) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.genero = genero;
    }

    public Long getId_pelicula() {
        return id_pelicula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
