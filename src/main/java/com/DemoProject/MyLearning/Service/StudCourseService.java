package com.DemoProject.MyLearning.Service;

import com.DemoProject.MyLearning.DTO.StudCourseDTO;
import com.DemoProject.MyLearning.Entity.StudentCourses;
import com.DemoProject.MyLearning.Repository.StudCourseRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.lang.String;
import java.util.List;

@Service
public class StudCourseService {

    @Autowired
    StudCourseRepository studCourseRepository;
    public StudentCourses save(@NotNull StudCourseDTO studCourseDTO) throws Exception{
        try {
            StudentCourses s = new StudentCourses();
            s.setDoj(studCourseDTO.getDoj());
            s.setDuration(studCourseDTO.getDuration());
            s.setCourses(studCourseDTO.getCourses());
            s.setStudent(studCourseDTO.getStudent());
            String status = Status(studCourseDTO.getDoj(), studCourseDTO.getDuration());
            s.setStatus(status);
            return studCourseRepository.saveAndFlush(s);
        }
        catch(Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }


    public List<StudentCourses> getListByIdS(Long id){
        List<StudentCourses> studentCourseList = studCourseRepository.findByStudentStudentId(id);
        return studentCourseList;
    }

    public List<StudentCourses> getListByIdC(Long id){
        List<StudentCourses> studentCourseList = studCourseRepository.findByCoursesCourseId(id);
        return studentCourseList;
    }
    public String Status(LocalDate localDate,Integer duration){
        try {
            int month = localDate.getMonthValue();
            int year = localDate.getYear();
            Date present = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(present);
            int presentMonth = cal.get(Calendar.MONTH);
            int presentYear = cal.get(Calendar.YEAR);
            if (presentYear > year) {
                if ((presentMonth + (12 - month) > duration))
                    return "Completed";
                else
                    return "In Progress";
            } else if (presentYear == year) {
                if (presentMonth < month)
                    return "Not Started";
                else
                    return "In Progress";
            } else {
                return "Not Started";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Status Unknown";
    }
}
