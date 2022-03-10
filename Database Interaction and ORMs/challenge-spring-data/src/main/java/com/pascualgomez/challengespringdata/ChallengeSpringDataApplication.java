package com.pascualgomez.challengespringdata;

import com.pascualgomez.challengespringdata.entity.Course;
import com.pascualgomez.challengespringdata.entity.CourseMember;
import com.pascualgomez.challengespringdata.entity.Student;
import com.pascualgomez.challengespringdata.repository.CourseMemberRepository;
import com.pascualgomez.challengespringdata.repository.CourseRepository;
import com.pascualgomez.challengespringdata.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class ChallengeSpringDataApplication {

	Student[] students = {new Student("Pascual", "Gomez", "pgl@gmail.com")
			, new Student("Oscar", "Peterson", "ospet@gmail.com")};
	List<Student> studentList = Arrays.asList(students);


	CourseMember[] members = {new CourseMember(1, 2), new CourseMember(1,1)};
	List<CourseMember> membersList = Arrays.asList(members);

	Course[] courses = {new Course("Matemáticas", "José"), new Course("Física", "Carlos")};
	List<Course> courseList = Arrays.asList(courses);

	public static void main(String[] args) {
			SpringApplication.run(ChallengeSpringDataApplication.class, args);
	}

	// Demo Function to test tables
/*	@Bean
	public CommandLineRunner demo(StudentRepository studentRepository, CourseRepository courseRepository
								, CourseMemberRepository courseMemberRepository) {
		return (args) -> {
			//Clean repositories
			studentRepository.deleteAll();
			courseMemberRepository.deleteAll();
			courseRepository.deleteAll();

			studentRepository.saveAll(studentList);
			courseMemberRepository.saveAll(membersList);
			courseRepository.saveAll(courseList);

			studentRepository.findAll().forEach(student -> System.out.println(student.toString()));
			System.out.println("-------");
			courseMemberRepository.findAll().forEach(courseMember -> System.out.println(courseMember.toString()));
			System.out.println("-------");
			courseRepository.findAll().forEach(course -> System.out.println(course.toString()));
			System.out.println("-------");

			studentRepository.findByName("Oscar").forEach(student -> System.out.println(student.toString()));
		};
	}*/
}