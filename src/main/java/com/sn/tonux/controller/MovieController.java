package com.sn.tonux.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sn.tonux.model.Movie;
import com.sn.tonux.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    @Qualifier(value = "movieService")
    MovieService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Method to fetch all movies from the db.
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Movie> getAll() {
        System.out.println("-------> : getAllMovies");
        logger.debug("Getting all movies.");
        return serv.getAllMovies();
    }
    
    /**
     * Method to count all movies from db.
     * @return
     */
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long getCountAll() {
        System.out.println("-------> : getCountAllMovies");
        logger.debug("Counting all movies.");
        return serv.getCountAllMovies();
    }

    /**
     * Method to fetch movie by id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Movie> getById(@PathVariable(value= "id") int id) {
        logger.debug("Getting movies with movie-id= {}.", id);
        return serv.findMovieById(id);
    }
    
    /**
     * Method to search for movie name with a regex.
     * @param name
     * @return
     */
    @GetMapping("search/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getByName(@PathVariable(value= "title") String regex) {
        logger.debug("Searching movie with title matching regex= {}.", regex);
        return serv.findMovieByTitleRegex(regex);
    }

}
