package com.example.muchos.controller;

import com.example.muchos.entity.Curso;
import com.example.muchos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return estudianteService.obtenerTodosLosCursos();
    }
}