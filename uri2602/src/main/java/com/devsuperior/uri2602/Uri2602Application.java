package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final List<CustomerMinProjection> list1 = repository.search1("Rs");
		final List<CustomerMinDTO> result1 = list1.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		System.out.println("\n **** RESULT SQL ****");
		result1.stream().forEach(obj -> System.out.println(obj));
		
		System.out.println("\n**** RESULT JPQL ****");
		final List<CustomerMinDTO> result2 = repository.search2("rs");
		result2.stream().forEach(obj -> System.out.println(obj));
	}
}
