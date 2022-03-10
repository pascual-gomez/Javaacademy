package com.pascualgomez.challengespringdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "tutor")
    private String tutor;

    public Course() {};

    public Course(String name, String tutor) {
        this.name = name;
        this.tutor = tutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tutor='" + tutor + '\'' +
                '}';
    }
}
