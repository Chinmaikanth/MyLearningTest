package com.DemoProject.MyLearning.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDTO {

    @NotNull(message = "Course ID should exist")
    private Long courseId;

    @NotBlank(message = "Course name should exist")
    private String courseName;
    private int duration;
}
