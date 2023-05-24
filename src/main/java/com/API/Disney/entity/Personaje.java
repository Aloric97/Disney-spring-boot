package com.API.Disney.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_personaje;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "historia")
    private String historia;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "id_personaje"),
            inverseJoinColumns = @JoinColumn(name = "id_pelicula"))
    private List<Pelicula> peliculas;


    private Personaje() {
    }

    public Personaje(String imagen, String nombre,int edad, Double peso, String historia, List<Pelicula> peliculas) {
        this.imagen = imagen;
        this.nombre=nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
