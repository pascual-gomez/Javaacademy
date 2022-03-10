package com.pascualgomez.challengespringdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByName(String name);
    List<Course> findByTutor(String tutor);
    Course findById(long id);
}
