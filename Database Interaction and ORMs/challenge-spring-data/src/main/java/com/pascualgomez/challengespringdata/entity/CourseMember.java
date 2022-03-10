package com.pascualgomez.challengespringdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "course_members")
public class CourseMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cm_id")
    Integer id;

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;

    public CourseMember() {};

    public CourseMember(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CourseMembers{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
