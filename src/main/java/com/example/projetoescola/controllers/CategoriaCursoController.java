package com.example.projetoescola.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repository.CategoriaCursoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/categoria-curso")
public class CategoriaCursoController {
  private CategoriaCursoRepository categoriaCursoRepository;

  CategoriaCursoController(CategoriaCursoRepository categoriaCursoRepository) {
    this.categoriaCursoRepository = categoriaCursoRepository;
  }

  @GetMapping()
  public List<CategoriaCurso> obterTodos() {
    return categoriaCursoRepository.obterTodos();
  }

  @PostMapping()
  public void inserir(@RequestBody CategoriaCurso categoriaCurso) {
    categoriaCursoRepository.inserir(categoriaCurso);
  }  
  
  
}
