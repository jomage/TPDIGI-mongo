package com.sn.tonux.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sn.tonux.model.Movie;

@Repository
public interface MovieDao extends MongoRepository<Movie, Integer> {

	List<Movie> findByTitleRegex(String regex);
	
}
