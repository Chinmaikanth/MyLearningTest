package com.DemoProject.MyLearning.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.internal.engine.messageinterpolation.ParameterTermResolver;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString//(exclude = "courses")
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @NotNull
    private Long studentId;
    private String name;
    //@Email(regexp = "[a-z0-9._%+@[a_z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String emailId;
    private String dateOfBirth;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent")
    Set<Courses> courses = new HashSet<>();*/
}
