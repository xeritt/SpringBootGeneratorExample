package org.generator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.generator.helpers.Base;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Movies Service", description = "Пример реализации REST сервиса")
public class GeneratorController {

    @Operation(summary = "Генерация кода")
    @GetMapping(value = "/generator/code")
    private String code(String PROJECT_HOME, String cfg_file, @Nullable String tmp_path) {
        //String PROJECT_HOME = "/home/tirex/java/generator/SpringBootGeneratorExample/";
        if (tmp_path==null) tmp_path = "";
        Base base = new Base();
        base.generate(PROJECT_HOME, cfg_file,"controller", tmp_path + "Controller", "Controller");
        base.generate(PROJECT_HOME, cfg_file, "model", tmp_path + "Model", "");
        base.fInterface = true;
        base.generate(PROJECT_HOME, cfg_file, "service", tmp_path + "IService", "Service");
        base.fInterface = false;
        base.generate(PROJECT_HOME, cfg_file, "service", tmp_path + "Service", "Service");
        base.generate(PROJECT_HOME, cfg_file, "repository", tmp_path + "Repository", "Repository");
        return "Code generate. Done. Ok";
    }
}