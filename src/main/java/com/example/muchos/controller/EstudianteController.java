package com.example.muchos.controller;

import com.example.muchos.entity.Estudiante;
import com.example.muchos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/{estudianteId}/cursos/{cursoId}")
    public ResponseEntity<Estudiante> inscribirEstudianteEnCurso(
            @PathVariable Long estudianteId, @PathVariable Long cursoId) {
        Estudiante estudiante = estudianteService.inscribirEstudianteEnCurso(estudianteId, cursoId);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }
}