package com.DemoProject.MyLearning.Entity;

import com.DemoProject.MyLearning.DTO.StudCourseDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentCourses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registers;
    private Integer duration;
    private LocalDate doj;
    private String status;
    /*@Column(name = "student_Id")
    private Long studentId;
    @Column(name = "course_Id")
    private Long courseId;*/

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")//,referencedColumnName = "courseId")
    Courses courses;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")//,referencedColumnName = "studentId")
    Student student;


    //private Set<StudentCourses> enrolledStudent = new HashSet<>();
}
