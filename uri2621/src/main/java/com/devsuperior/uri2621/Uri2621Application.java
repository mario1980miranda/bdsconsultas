package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		final List<ProductMinProjection> list1 = repository.search1(10, 20, "P");
		final List<ProductMinDTO> result1 = list1.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		final List<ProductMinDTO> result2 = repository.search2(10, 20, "P");
		
		System.out.println("\n **** RESULT SQL ****");
		result1.stream().forEach(obj -> System.out.println(obj));
		
		System.out.println("\n**** RESULT JPQL ****");
		result2.stream().forEach(obj -> System.out.println(obj));
	}
}
