package com.DemoProject.MyLearning.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {

    @NotNull(message = "Student ID should exist")
    private Long studentId;

    @NotBlank(message = "Student name should exist")
    private String name;
    private String emailId;
    private String dateOfBirth;
}
