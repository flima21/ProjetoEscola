package com.example.projetoescola.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.DTO.CursoDTO;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.services.CursoService;

@RestController
@RequestMapping("api/cursos")
public class CursoController {
  private CursoService cursoService;

  public CursoController(CursoService cursoService) {
    this.cursoService = cursoService;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Curso salvar(@RequestBody CursoDTO curso) {
    return cursoService.salvar(curso);
  }

  
}
