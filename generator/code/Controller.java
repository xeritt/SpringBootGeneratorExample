package {PACKAGE}.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import {PACKAGE}.model.{MODEL};
import {PACKAGE}.service.{MODEL}Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
/**
{PATH}    = "/movies"
{VARIBLE} = "movie"
{MODEL}   = "Movie"
{MODELS}  = "Movies"
*/

@RestController
@Tag(name = "{MODELS} Service", description = "Пример реализации REST сервиса")
public class {MODEL}Controller {

    @Autowired
    {MODEL}Service {VARIBLE}Service;

    @Operation(summary = "Получение списка сущностей")
    @GetMapping(value = "{PATH}", produces = "application/json")
    private List<{MODEL}> get{MODELS}() {
        return {VARIBLE}Service.getAll{MODELS}();
    }

    @GetMapping("{PATH}/{id}")
    @Operation(summary = "Получение сущности по id")
    private {MODEL} get{MODEL}(@PathVariable("id") int id) {
        return {VARIBLE}Service.get{MODEL}ById(id);
    }

    @Operation(summary = "Удаление сущности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешная операция"),
            @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
            @ApiResponse(responseCode = "404", description = "строка не найдена", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
    })
    @DeleteMapping("{PATH}/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private void delete{MODEL}(@PathVariable("id") int id) {
        {VARIBLE}Service.delete(id);
    }

    @Operation(summary = "Изменение сущности по id")
    @PostMapping(value = "{PATH}/save", produces = "application/json")
    private int save{MODEL}(@RequestBody {MODEL} {VARIBLE}) {
        {VARIBLE}Service.saveOrUpdate({VARIBLE});
        return {VARIBLE}.getId();
    }

    @Operation(summary = "Создание сущности")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешная операция"),
            @ApiResponse(responseCode = "400", description = "неверный формат запроса"),
            @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
    })
    @PostMapping(value = "{PATH}/new", produces = "application/json")
    @ResponseBody
    public {MODEL} create{MODEL}(@Validated @NotBlank @RequestBody {MODEL} {VARIBLE}) {
        return {VARIBLE}Service.create{MODEL}({VARIBLE});
    }
}