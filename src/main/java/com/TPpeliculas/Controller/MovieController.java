package com.TPpeliculas.Controller;

import com.TPpeliculas.Exceptions.BussinesException;
import com.TPpeliculas.Model.Movie;
import com.TPpeliculas.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies/anioLanzamiento/{anioLanzamiento}")
    public ResponseEntity<?> buscarPeliculaPorAnio(@PathVariable int anioLanzamiento){
        List<Movie> listaPeliculas =  service.findByAnio(anioLanzamiento);
        if (listaPeliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(listaPeliculas);
    }

    @GetMapping("/movies/id/{id}")
    public ResponseEntity<?> buscarPeliculaPorId(@PathVariable Long id){
        Optional<Movie> movieOptional =  service.getMovieByID(id);
        if (movieOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movieOptional.get());
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> listaPeliculas =  service.getAllMovies();
        if(listaPeliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(listaPeliculas);
    }

    @PostMapping("/movies")
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie){
        try {
            Movie m = service.createMovie(movie);
            return ResponseEntity.ok(m);
        } catch (BussinesException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
