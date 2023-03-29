package com.example.demo;

import com.example.demo.controller.StudentRepository;
import com.example.demo.entities.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex04Application 
{
	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) 
	{
		SpringApplication.run(Ex04Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("List Student:");
			studentRepository.save(new Student(1, "An", 18, "an@gmail.com", "5.5"));
			studentRepository.save(new Student(2, "Binh", 19, "binh@gmail.com", "7.0"));
			studentRepository.save(new Student(3, "Duc", 20, "duc@gmail.com", "8.0"));
			ArrayList<Student> lstStudent =  (ArrayList<Student>) studentRepository.findAll();
			print(lstStudent);
			System.out.println("List of students whose age is greater than or equal to 19: ");
			List<Student> lstSAgeThan19 = studentRepository.findByAgeGreaterThan(19);
			print(lstSAgeThan19);
			System.out.println("List of students whose ielts score is equal to 7.0: ");
			List<Student> lstSILScore = studentRepository.findByIeltsScore("7.0");
			print(lstSILScore);
			System.out.println("List of students whose name contains the word n: ");
			List<Student> lstSNameLike = studentRepository.findByNameContaining("n");
			print(lstSNameLike);
		};
	}
	
	public void print(List<Student> lstSAgeThan19) {
		for(Student s : lstSAgeThan19) {
			System.out.println(s);
		}
	}

}
