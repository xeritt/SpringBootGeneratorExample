package org.arpit.java2blog.controller;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.arpit.java2blog.model.Movie;
import org.arpit.java2blog.service.MovieService;
import org.generator.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

//@RequestMapping("/movies")
@RestController
@Tag(name = "Movies Service", description = "Пример реализации REST сервиса")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Operation(summary = "Генерация кода")
    @GetMapping(value = "/generator/code")
    private String code() {
        String PROJECT_HOME = "/home/tirex/java/generator/SpringBootH2DatabaseExample-master/";
        Base base = new Base();
        base.generate(PROJECT_HOME, "movie","controller", "Controller", "Controller");
        base.generate(PROJECT_HOME, "movie", "model", "Model", "");
        base.fInterface = true;
        base.generate(PROJECT_HOME, "movie", "service", "IService", "Service");
        base.fInterface = false;
        base.generate(PROJECT_HOME, "movie", "service", "Service", "Service");
        base.generate(PROJECT_HOME, "movie", "repository", "Repository", "Repository");

        return "Hello";
    }

    @Operation(summary = "Получение списка сущностей")
    @GetMapping(value = "/movies", produces = "application/json")
    private List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    @Operation(summary = "Получение сущности по id")
    private Movie getMovie(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }

    @Operation(summary = "Удаление сущности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешная операция"),
            @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
            @ApiResponse(responseCode = "404", description = "строка не найдена", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
    })
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private void deleteMovie(@PathVariable("id") int id) {
        movieService.delete(id);
    }

    @Operation(summary = "Изменение сущности по id")
    @PostMapping(value = "/movies/save", produces = "application/json")
    private int saveMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
        return movie.getId();
    }

    @Operation(summary = "Создание сущности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешная операция"),
            @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
            @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
    })
    @PostMapping(value = "/movies/new", produces = "application/json")
    @ResponseBody
    public Movie createMovie(@Validated @NotBlank @RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
}