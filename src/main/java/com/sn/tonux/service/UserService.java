package com.sn.tonux.service;

import com.sn.tonux.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public void createUser(List<User> emp);


    public Collection<User> getAllUsers();


    public Optional<User> findUserById(int id);


	public Optional<User> findUserByName(String name);


    public void deleteUserById(int id);

    
	public void deleteUserByName(String name);


    public void updateUser(User user);


    public void deleteAllUsers();


	public Long getCountAllUsers();
}
