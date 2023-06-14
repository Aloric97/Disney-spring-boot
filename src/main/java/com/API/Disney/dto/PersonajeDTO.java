package com.API.Disney.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonajeDTO {




    private String imagen;

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    private String nombre;

    @NotNull(message = "the age can't be null")
    private int edad;

    @NotNull(message = "the heigh can't be null")
    private Double peso;


    private String historia;


    public PersonajeDTO(String imagen, String nombre, int edad, Double peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
