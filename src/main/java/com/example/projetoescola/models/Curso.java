package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 200)
  private String nome;

  @Column(nullable = false)
  private int cargaHoraria;

  @ManyToOne
  @JoinColumn(name="categoriaCurso_id")
  
  private CategoriaCurso categoriaCurso;

  public CategoriaCurso getCategoriaCurso() {
    return categoriaCurso;
  }

  public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
    this.categoriaCurso = categoriaCurso;
  }

  public Curso(Long id, String nome, int cargaHoraria) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
  }

  public Curso() {

  }
  
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

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  @Override
  public String toString() {
    return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
  }

}
