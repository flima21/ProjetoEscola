package com.example.projetoescola.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
  private Long id;
  
  private String nome;

  private int cargaHoraria;
  private int categoriaCursoId;
}
