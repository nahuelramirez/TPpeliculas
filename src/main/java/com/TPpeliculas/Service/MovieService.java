package com.TPpeliculas.Service;

import com.TPpeliculas.Exceptions.BussinesException;
import com.TPpeliculas.Model.Movie;
import com.TPpeliculas.Repository.MovieRepository;
import com.TPpeliculas.Validations.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieValidator validator;

    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

    public Optional<Movie> getMovieByID(Long id){
        return repository.findById(id);
    }

    public Boolean verificacionTituloYDirector(String titulo, String director){
        return repository.existsByTituloAndDirector(titulo,director);
    }

    public Movie createMovie(Movie movie) throws BussinesException {
        validator.verificarDatos(movie);
        validator.verificarAnio(movie);
        validator.verificarGenero(movie);

        return repository.save(movie);
    }

    public List<Movie> findByAnio(int anio){
        return repository.findByAnioLanzamiento(anio);
    }


}
