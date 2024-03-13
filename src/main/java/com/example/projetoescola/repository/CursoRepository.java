package com.example.projetoescola.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
  @Autowired
  private EntityManager entityManager;

  @Transactional
  public Curso inserir(Curso curso) {
    this.entityManager.merge(curso);
    return curso;
  }

  public List<Curso> obterTodos() {
    return this.entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
  }

  public List<Curso> obterPorNome(String nome) {
    String jpql = "select c from Curso c where c.nome like :nome";
    TypedQuery<Curso> query = entityManager.createQuery(jpql,Curso.class);

    query.setParameter("nome", "%" + nome + "%");

    return query.getResultList();
  }

}
