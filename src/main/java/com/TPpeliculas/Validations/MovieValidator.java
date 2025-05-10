package com.TPpeliculas.Validations;

import com.TPpeliculas.Exceptions.BussinesException;
import com.TPpeliculas.Model.Movie;
import com.TPpeliculas.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieValidator {

    @Autowired
    private MovieRepository repository;

    public void verificarDatos(Movie movie) throws BussinesException {
        Boolean flag = repository.existsByTituloAndDirector(movie.getTitulo(), movie.getDirector());
        if (flag) {
            throw new BussinesException("Ya existe esta pelicula");
        }
    }

    public void verificarAnio(Movie movie) throws BussinesException{
        if (movie.getAnioLanzamiento() < 1895 || movie.getAnioLanzamiento() > 2027){
            throw new BussinesException("El año de lanzamiento no se encuentra en el rango");
        }
    }

    public void verificarGenero(Movie movie) throws BussinesException{
        if(movie.getAnioLanzamiento() < 1920 && movie.getGenero().equals("Documental")){
            throw new BussinesException("No existen documentales previos a 1920");
        }

    }
}
