package com.bitlabs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bitlabs.entity.Course;
import com.bitlabs.entity.Student;
import com.bitlabs.repository.CourseRepository;
import com.bitlabs.repository.StudentRepository;



@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
	
	
    private StudentRepository studentRepository=null;
    
    private CourseRepository courseRepository=null;
    @Autowired
    public StudentCourseController(StudentRepository studentRepository,
                                   CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping("/add")
    public Student saveStudentWithCourse(@RequestBody Student student){
//    	ArrayList<Course> course=new ArrayList<>();
//    	//java.util.List<Course> course = student.getCourses();
//        for(Course c:student.getCourses()) {
//        	course.add(c);
//        }
//    	courseRepository.saveAll(course);
//      
      return   studentRepository.save(student);
    }

   
    @GetMapping
    public List<Student> findALlStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }

    @GetMapping("/findCourse/{name}")
    public List<Course> findCourse(@PathVariable String name){
        return  courseRepository.findByNameContaining(name);
    }

}
