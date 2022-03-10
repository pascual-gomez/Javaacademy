package com.pascualgomez.challengespringdata.controller;

import com.pascualgomez.challengespringdata.entity.Course;
import com.pascualgomez.challengespringdata.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping(path="/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCourse (@RequestParam String name, @RequestParam String tutor) {

        Course n = new Course();
        n.setName(name);
        n.setTutor(tutor);
        courseRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllUsers() {
        return courseRepository.findAll();
    }
}

