package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		final List<EmpregadoDeptProjection> list1 = repository.search1();
		final List<EmpregadoDeptDTO> result1 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		final List<EmpregadoDeptDTO> result2 = repository.search2();
		
		final List<EmpregadoDeptProjection> list3 = repository.search1();
		final List<EmpregadoDeptDTO> result3 = list3.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		System.out.println("\n **** RESULT SQL LEFT JOIN ****");
		result1.stream().forEach(obj -> System.out.println(obj));
		
		System.out.println("\n **** RESULT SQL NOT IN ****");
		result3.stream().forEach(obj -> System.out.println(obj));
		
		System.out.println("\n**** RESULT JPQL NOT IN ****");
		result2.stream().forEach(obj -> System.out.println(obj));
	}
}
