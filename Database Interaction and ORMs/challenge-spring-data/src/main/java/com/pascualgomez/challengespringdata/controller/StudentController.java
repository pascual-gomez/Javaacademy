package com.pascualgomez.challengespringdata.controller;

import com.pascualgomez.challengespringdata.entity.Student;
import com.pascualgomez.challengespringdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping(path="/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewStudent (@RequestBody Student student) {

        Student n = new Student();
        n.setName(student.getName());
        n.setLastName(student.getLastName());
        n.setEmail(student.getEmail());
        studentRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        return studentRepository.findAll();
    }
}
