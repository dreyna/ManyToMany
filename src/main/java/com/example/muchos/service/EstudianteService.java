package com.example.muchos.service;

import com.example.muchos.entity.Curso;
import com.example.muchos.entity.Estudiante;
import com.example.muchos.exception.ResourceNotFoundException;
import com.example.muchos.repository.CursoRepository;
import com.example.muchos.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Estudiante inscribirEstudianteEnCurso(Long estudianteId, Long cursoId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        estudiante.getCursos().add(curso);
        curso.getEstudiantes().add(estudiante);

        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }
}