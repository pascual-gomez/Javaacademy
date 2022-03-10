package com.pascualgomez.challengespringdata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseMemberRepository extends CrudRepository<CourseMember, Integer> {
    CourseMember findById(long id);
    List<CourseMember> findByStudentId(long studentId);
    List<CourseMember> findByCourseId(long courseId);
}
