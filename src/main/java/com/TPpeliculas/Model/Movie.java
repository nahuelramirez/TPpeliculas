package com.TPpeliculas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "Movies")
public class Movie {
    @Id
    @GeneratedValue
    private Long ID;

    @NotBlank(message = "El titulo es obligatorio.")
    @Size(min = 2, max = 100, message = "El titulo debe tener entre 2 y 100 caracteres.")
    private String titulo;

    @NotBlank(message = "El director es obligatorio.")
    private String director;

    @Column (nullable = false)
    @Min(value = 1895)
    @Max(value = 2027)
    private int anioLanzamiento;

    @Column(nullable = false)
    private String genero;

    public Movie() {
    }

    public Movie(Long ID, String titulo, String director, int anioLanzamiento, String genero) {
        this.ID = ID;
        this.titulo = titulo;
        this.director = director;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
    }

    public Long getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
