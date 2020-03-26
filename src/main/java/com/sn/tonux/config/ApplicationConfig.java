package com.sn.tonux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sn.tonux.service.MovieService;
import com.sn.tonux.service.MovieServiceImpl;
import com.sn.tonux.service.UserService;
import com.sn.tonux.service.UserServiceImpl;

@Configuration
@ComponentScan("com.sn.tonux")
public class ApplicationConfig {

    @Bean(name="userService")
    public UserService getTopoService() {
        return new UserServiceImpl();
    }

    @Bean(name="movieService")
    public MovieService getMovieService() {
        return new MovieServiceImpl();
    }

}
