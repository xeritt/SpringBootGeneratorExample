package org.arpit.java2blog.service;

import org.arpit.java2blog.model.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    @Transactional
    void saveOrUpdate(Movie mvoie);

    @Transactional
    void delete(int id);

    @Transactional
    Movie createMovie(Movie movie);
}
