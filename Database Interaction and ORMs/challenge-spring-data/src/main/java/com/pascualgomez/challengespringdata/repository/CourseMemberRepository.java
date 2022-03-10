package com.pascualgomez.challengespringdata.repository;

import com.pascualgomez.challengespringdata.entity.CourseMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseMemberRepository extends CrudRepository<CourseMember, Integer> {
    CourseMember findById(long id);
    List<CourseMember> findByStudentId(long studentId);
    List<CourseMember> findByCourseId(long courseId);
}
