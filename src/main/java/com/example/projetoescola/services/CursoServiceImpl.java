package com.example.projetoescola.services;

import org.springframework.stereotype.Service;

import com.example.projetoescola.DTO.CursoDTO;
import com.example.projetoescola.exceptions.RegraNegocioException;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repository.CategoriaCursoRepository;
import com.example.projetoescola.repository.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
  private final CursoRepository cursoRepository;
  private final CategoriaCursoRepository  categoriaCursoRepository;

  @Override
  public Curso salvar(CursoDTO cursoDTO) {
    CategoriaCurso categ = categoriaCursoRepository.findById(cursoDTO.getId()).orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
    
    Curso curso = new Curso();
    
    curso.setId(cursoDTO.getId());
    curso.setNome(cursoDTO.getNome());
    curso.setCargaHoraria(cursoDTO.getCargaHoraria());
    curso.setCategoriaCurso(categ);

    return cursoRepository.save(curso);
  }

  
}
