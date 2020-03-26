package com.sn.tonux.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "movies")
public class Movie {

    @Id
    private BigInteger id;
    private String title;
    private String genres;
    
	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", genres=" + genres + "]";
	}
    
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
}
