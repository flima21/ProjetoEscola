package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String nome;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="ALUNO_PROFESSOR", joinColumns = {@JoinColumn(name="PROFESSOR_ID")})
  private List<Aluno> alunos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(List<Aluno> alunos) {
    this.alunos = alunos;
  }
}
