package com.pascualgomez.challengespringdata.controller;

import com.pascualgomez.challengespringdata.entity.CourseMember;
import com.pascualgomez.challengespringdata.repository.CourseMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping(path="/course_members")
public class CourseMemberController {
    @Autowired
    private CourseMemberRepository courseMemberRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCourseMember (@RequestBody CourseMember courseMember) {

        CourseMember n = new CourseMember();
        n.setStudentId(courseMember.getStudentId());
        n.setCourseId(courseMember.getCourseId());
        courseMemberRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CourseMember> getAllUsers() {
        return courseMemberRepository.findAll();
    }
}


