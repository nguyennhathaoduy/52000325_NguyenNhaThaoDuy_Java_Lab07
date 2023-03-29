package com.example.demo;

import com.example.demo.controller.StudentRepository;
import com.example.demo.entities.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex03Application 
{
	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Ex03Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("List Student:");
			Student s1 = new Student();
			s1.setName("An");
			s1.setAge(18);
			s1.setEmail("an@gmail.com");
			s1.setIeltsScore("5.5");
			studentRepository.save(s1);
			studentRepository.save(new Student(2, "Binh", 20, "binh@gmail.com", "7.0"));
			studentRepository.save(new Student(3, "Duc", 20, "duc@gmail.com", "8.0"));
			ArrayList<Student> lstStudent =  (ArrayList<Student>) studentRepository.findAll();
			print(lstStudent);
			studentRepository.save(new Student(1, "Anh", 18, "an@gmail.com", "5.5"));
			System.out.println("Update:");
			System.out.println(studentRepository.findById(1));
			studentRepository.deleteById(2);
			System.out.println("Delete:");
			print((ArrayList<Student>) studentRepository.findAll());
		};
	}
	public void print(ArrayList<Student> lstStudent) 
	{
		for(Student s : lstStudent) {
			System.out.println(s);
		}
	}
}
