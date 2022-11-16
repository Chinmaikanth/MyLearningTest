package com.DemoProject.MyLearning.Controller;

import com.DemoProject.MyLearning.DTO.StudentDTO;
import com.DemoProject.MyLearning.Entity.Student;
import com.DemoProject.MyLearning.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/DemoProject")
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/Student")
    public Student AddStudent(@RequestBody StudentDTO studentDTO) throws Exception{
        return studentservice.save(studentDTO);
    }
    @GetMapping("/Student")
    public List<Student> getStudent(){
        return studentservice.getAllStudents();
    }

    /*@GetMapping("/studentAndCourses")
    @GetMapping("/Student/{id}")
    public Student findById(@PathVariable Integer id){
        return studentservice.findById(id);
    }*/
    @DeleteMapping("/Student/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentservice.delete(id);
    }
}
