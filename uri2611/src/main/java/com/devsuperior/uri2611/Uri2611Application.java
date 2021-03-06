package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final List<MovieMinProjection> list1 = repository.search1("Action");
		
		final List<MovieMinDTO> result1 = list1.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());
		final List<MovieMinDTO> result2 = repository.search2("action");
		
		System.out.println("\n **** RESULT SQL ****");
		result1.stream().forEach(obj -> System.out.println(obj));
		
		System.out.println("\n**** RESULT JPQL ****");
		result2.stream().forEach(obj -> System.out.println(obj));
		
	}
}
