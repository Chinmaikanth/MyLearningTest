package com.DemoProject.MyLearning.Controller;

import com.DemoProject.MyLearning.DTO.StudCourseDTO;
import com.DemoProject.MyLearning.Entity.StudentCourses;
import com.DemoProject.MyLearning.Repository.CoursesRepository;
import com.DemoProject.MyLearning.Repository.StudCourseRepository;
import com.DemoProject.MyLearning.Repository.StudentRepository;
import com.DemoProject.MyLearning.Service.StudCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/DemoProject")
public class StudCourseController {

    @Autowired
    StudCourseService studCourseService;
    @Autowired
    StudCourseRepository studCourseRepository;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/studcourse")
    public StudentCourses Enroll(@RequestBody StudCourseDTO studCourseDTO) throws Exception{
        return studCourseService.save(studCourseDTO);
    }

    @GetMapping("/studcourse")
    public List<StudentCourses> getCourses(){ return studCourseRepository.findAll();}

    @GetMapping("findStudent/{id}")
    public List<StudentCourses> getStudentDetails(@PathVariable Long id){
        return studCourseService.getListByIdS(id);
    }


    @GetMapping("findCourse/{id}")
    public List<StudentCourses> getCourseDetails(@PathVariable Long id){
        return studCourseService.getListByIdC(id);}

    /*@PutMapping("/{courseId}/studcourse/{studentId}")
    StudentCourses enrollStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        Courses courses = coursesRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
        //courses.enrollStudent(student);
        //return studCourseRepository.save();
    }*/
}
