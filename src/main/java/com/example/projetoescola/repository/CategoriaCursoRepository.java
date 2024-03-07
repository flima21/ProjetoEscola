package com.example.projetoescola.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
  @Autowired
  private EntityManager entityManager;

  @Transactional
  public CategoriaCurso inserir(CategoriaCurso categoriaCurso) {
    this.entityManager.merge(categoriaCurso);
    return categoriaCurso;
  }

  public List<CategoriaCurso> obterTodos() {
    return this.entityManager.createQuery("select c from CategoriaCurso c",CategoriaCurso.class).getResultList();
  }
}
