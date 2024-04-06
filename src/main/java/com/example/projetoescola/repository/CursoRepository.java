package com.example.projetoescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNome(String nome);
    List<Curso> findByNomeContaining(String nome);
    List<Curso> findByCargaHorariaGreaterThanEqual(int cargaHoraria);
    List<Curso> findByCargaHorariaLessThanEqual(int cargaHoraria);
}