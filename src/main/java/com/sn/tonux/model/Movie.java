package com.sn.tonux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "movies")
public class Movie {

    @Id
    private int id;
    private String title;
    private String genres;
    
	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", genres=" + genres + "]";
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
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