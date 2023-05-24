package com.API.Disney.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    List<Pelicula> peliculas;


    private Genero() {
    }

    public Genero(String nombre, String imagen, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculas = peliculas;
    }

    public Long getId_genero() {
        return id_genero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
