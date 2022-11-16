package com.DemoProject.MyLearning.DTO;

import com.DemoProject.MyLearning.Entity.Courses;
import com.DemoProject.MyLearning.Entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class StudCourseDTO implements Serializable {
    private Integer duration;
    private LocalDate doj;
    private Student student;
    private Courses courses;
}
