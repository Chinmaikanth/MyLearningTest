package com.DemoProject.MyLearning.Service;

import com.DemoProject.MyLearning.DTO.CoursesDTO;
import com.DemoProject.MyLearning.Entity.Courses;
import com.DemoProject.MyLearning.Repository.CoursesRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CoursesRepository coursesRepository;
    public Courses save(@NotNull CoursesDTO coursesDTO){
       Courses c = new Courses();
       c.setCourseId(coursesDTO.getCourseId());
       c.setCourseName(coursesDTO.getCourseName());
       c.setDuration(coursesDTO.getDuration());
       return coursesRepository.save(c);
    }
    public List<Courses> getALLCourses(){
        return coursesRepository.findAll();
    }

    /*public Courses findById(Integer id) {
        return CoursesRepository.findByCourseId(id);
    }*/
    public void delete(Long id){
        coursesRepository.deleteById(id);
    }
}
