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
/*
@Repository
public class CursoRepository {
  @Autowired
  private EntityManager entityManager;

  @Transactional
  public Curso inserir(Curso curso) {
    this.entityManager.merge(curso);
    return curso;
  }

  @Transactional
  public Curso update(Curso curso) {
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
 */