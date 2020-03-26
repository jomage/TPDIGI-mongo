package com.sn.tonux.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.sn.tonux.model.Movie;

public interface MovieService {

	Collection<Movie> getAllMovies();

	Long getCountAllMovies();

	Optional<Movie> findMovieById(int id);

	List<Movie> findMovieByTitleRegex(String regex);

}
