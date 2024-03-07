package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repository.CategoriaCursoRepository;
import com.example.projetoescola.repository.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository, @Autowired CategoriaCursoRepository categoriaCursoRepository) {
		return args -> {
			cursoRepository.inserir(new Curso(0l,"ADS",2000));
			cursoRepository.inserir(new Curso(0l,"Matemática",2050));

			categoriaCursoRepository.inserir(new CategoriaCurso(null,"Informática"));
			categoriaCursoRepository.inserir(new CategoriaCurso(null,"Cálculo"));

			System.out.println("Exemplo de Lista");
			List<Curso> lista = cursoRepository.obterTodos();
			lista.forEach(c -> {
				System.out.println(c.getId());
			});
			
			
			System.out.println("Exemplo de Lista por nome");
			List<Curso> listaPorNome = cursoRepository.obterPorNome("ADS");
			listaPorNome.forEach(System.out::println);

			System.out.println("Exemplo de categorias");
			List<CategoriaCurso> listaPorCategoria = categoriaCursoRepository.obterTodos();
			listaPorCategoria.forEach(System.out::println);
		};
	}

}
