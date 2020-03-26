package com.sn.tonux.controller;


import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sn.tonux.model.User;
import com.sn.tonux.service.UserService;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {



    @Autowired
    @Qualifier(value = "userService")
    UserService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * Method to fetch all users from the db.
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> getAll() {
        System.out.println("-------> : getAllUsers");
        logger.debug("Getting all users.");
        return serv.getAllUsers();
    }
    
    /**
     * Method to count all users from db.
     * @return
     */
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long getCountAll() {
        System.out.println("-------> : getCountAllUsers");
        logger.debug("Counting all users.");
        return serv.getCountAllUsers();
    }

    /**
     * Method to fetch user by id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable(value= "id") int id) {
        logger.debug("Getting users with user-id= {}.", id);
        return serv.findUserById(id);
    }
    
    /**
     * Method to fetch user by name.
     * @param name
     * @return
     */
    @GetMapping("named/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getByName(@PathVariable(value= "name") String name) {
        logger.debug("Fetching user with user-name= {}.", name);
        return serv.findUserByName(name);
    }
    
    /**
     * Method to update user by id.
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable(value= "id") int id, @RequestBody User user) {
        logger.debug("Updating user with user-id= {}.", id);
        user.setId(id);
        serv.updateUser(user);
        return "user record for user-id= " + id + " updated.";
    }

    /**
     * Method to delete user by id.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value= "id") int id) {
        logger.debug("Deleting user with user-id= {}.", id);
        serv.deleteUserById(id);
        return "user record for user-id= " + id + " deleted.";
    }

    /**
     * Method to delete user by name.
     * @param name
     * @return
     */
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByName(@PathVariable(value= "name") String name) {
        logger.debug("Deleting user with user-name= {}.", name);
        serv.deleteUserByName(name);
        return "user record for user-name= \"" + name + "\" deleted.";
    }

    /**
     * Method to delete all users from the db.
     * @return
     */
    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all users.");
        serv.deleteAllUsers();
        return "All users records deleted.";
    }

}
