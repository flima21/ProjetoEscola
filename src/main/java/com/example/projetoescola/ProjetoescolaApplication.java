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
			categoriaCursoRepository.save(new CategoriaCurso(0,"Informática"));
			categoriaCursoRepository.save(new CategoriaCurso(0,"Cálculo"));

			cursoRepository.save(new Curso(0l,"ADS",2000));
			cursoRepository.save(new Curso(0l,"Matemática",2050));

			System.out.println("Exemplo de Lista");
			List<Curso> lista = cursoRepository.findAll();
			lista.forEach(c -> {
				System.out.println(c.getId());
			});

			
			System.out.println("Exemplo de Lista por nome");
			List<Curso> listaPorNome = cursoRepository.findByNome("ADS");
			listaPorNome.forEach(System.out::println);
			
			// System.out.println("Exemplo de categorias");
			// List<CategoriaCurso> listaPorCategoria = categoriaCursoRepository.obterTodos();

			// listaPorCategoria.forEach(System.out::println);

			// Curso cAds = lista.get(0);
			// Curso cSi  = lista.get(1);

			// cAds.setCategoriaCurso(listaPorCategoria.get(0));
			// cSi.setCategoriaCurso(listaPorCategoria.get(1));

			// cursoRepository.update(cSi);
			// cursoRepository.update(cAds);
		};
	}

}
