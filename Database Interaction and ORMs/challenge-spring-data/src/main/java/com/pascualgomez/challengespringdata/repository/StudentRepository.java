package com.pascualgomez.challengespringdata.repository;

import com.pascualgomez.challengespringdata.entity.Student;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByLastName(String lastname);
    List<Student> findByEmail(String email);
    Student findById(long id);
}
