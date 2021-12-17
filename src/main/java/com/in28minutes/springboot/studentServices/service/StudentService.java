package com.in28minutes.springboot.studentServices.service;

import com.in28minutes.springboot.studentServices.model.Course;
import com.in28minutes.springboot.studentServices.model.Student;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentService {
    private static List<Student> students = new ArrayList<>();

    static {
// Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

        Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
                new ArrayList<>(Arrays.asList(course1, course2)));
        Student satish = new Student("Student2", "Satish T", "Hiker, Programmer and Architect",
                new ArrayList<>(Arrays.asList(course1, course2)));

        students.add(ranga);
        students.add(satish);
    }

    public List<Student> retrieveAllStudents(){
        return students;
    }

    public Student retrieveStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }
        return student.getCourses();
    }

    public Course retrieveCourse(String studentId, String courseId){
        Student student = retrieveStudent((studentId));

        if(student == null){
            return null;
        }
        for(Course course : student.getCourses()){
            if(course.getId().equals(courseId)){
                return course;
            }
        }
        return null;
    }

    private SecureRandom random = new SecureRandom();

    public Course addCourse(String studentId, Course course){
        Student student = retrieveStudent(studentId);

        if(student == null){
            return null;
        }
        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);

        student.getCourses().add(course);

        return course;
    }
}
