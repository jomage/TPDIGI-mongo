package com.sn.tonux.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sn.tonux.dao.MovieDao;
import com.sn.tonux.model.Movie;

public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDao dao;

	@Override
	public Collection<Movie> getAllMovies() {
		return dao.findAll();
	}

	@Override
	public Long getCountAllMovies() {
		return dao.count();
	}

	@Override
	public Optional<Movie> findMovieById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Movie> findMovieByTitleRegex(String regex) {
		return dao.findByTitleRegex(regex);
	}

}
