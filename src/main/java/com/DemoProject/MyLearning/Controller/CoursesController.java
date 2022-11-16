package com.DemoProject.MyLearning.Controller;

import com.DemoProject.MyLearning.DTO.CoursesDTO;
import com.DemoProject.MyLearning.Entity.Courses;
import com.DemoProject.MyLearning.Repository.CoursesRepository;
import com.DemoProject.MyLearning.Repository.StudentRepository;
import com.DemoProject.MyLearning.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/DemoProject")
public class CoursesController {
    @Autowired
    CourseService courseService;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/course")
    public Courses AddCourses(@RequestBody @Valid CoursesDTO coursesDTO) throws Exception {
        return courseService.save(coursesDTO);
    }

    @GetMapping("/course")
    public List<Courses> getCourses(){
        return courseService.getALLCourses();
    }
    /*@GetMapping("/course/{id}")
    public Courses findById(@PathVariable Integer id){
        return CourseService.findById(id);
    }*/
    @DeleteMapping("/course/{id}")
    public void deleteStudent(@PathVariable Long id){
        courseService.delete(id);
    }

    /*@PutMapping("/{courseId}/students/{studentId}")
    Courses enrollStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        Courses courses = coursesRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
        courses.enrollStudent(student);
        return coursesRepository.save(courses);
    }*/

}
