package com.sn.tonux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBList;

@Document(collection= "users")
public class User {

    @Id
    private int id;
    private String name;
    private String gender;
    private Integer age;
    private String occupation;
    private BasicDBList movies;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", occupation="
				+ occupation + ", movies=" + movies + "]";
	}
    
    // ## GETTERS & SETTERS ##
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public BasicDBList getMovies() {
		return movies;
	}
	public void setMovies(BasicDBList movies) {
		this.movies = movies;
	}
 
}
