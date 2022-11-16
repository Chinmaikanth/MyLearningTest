package com.DemoProject.MyLearning.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString//(exclude = "enrolledStudent")
@NoArgsConstructor
public class Courses implements Serializable {

    @Id
    private Long courseId;
    private String courseName;
    private Integer duration;



    /*@ManyToMany
    @JoinTable(
            name="student_enrolled",
            joinColumns  = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudent = new HashSet<>();

    public void enrollStudent(Student student) {
        enrolledStudent.add(student);
    }*/
}
