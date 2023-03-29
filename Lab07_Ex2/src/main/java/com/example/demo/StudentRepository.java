package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
