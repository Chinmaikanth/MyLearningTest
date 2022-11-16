package com.DemoProject.MyLearning.Service;

import com.DemoProject.MyLearning.DTO.StudentDTO;
import com.DemoProject.MyLearning.Entity.Student;
import com.DemoProject.MyLearning.ExceptionHandler.InvalidEmailException;
import com.DemoProject.MyLearning.Repository.StudentRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student save(@NotNull StudentDTO studentDTO) throws Exception{
        try {
            Student s = new Student();
            s.setStudentId(studentDTO.getStudentId());
            s.setName(studentDTO.getName());
            String a = EmailValid(studentDTO.getEmailId());
            s.setEmailId(a);
            s.setDateOfBirth(studentDTO.getDateOfBirth());
            return studentRepository.save(s);
        }
        catch(InvalidEmailException e){
            throw new InvalidEmailException();
        }
    }

    public String EmailValid(String email) throws Exception{
        try {
            String[] chunks = email.split("@");
            if (chunks.length == 2) {
                String[] chunk2 = chunks[1].split("\\.");
                if (chunk2.length == 2)
                    return email;
            }
            throw new Exception();
        } catch (Exception e) {
            throw new InvalidEmailException();
        }
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    /*public Student findById(Integer id){
        return StudentRepository.findByStudentId(id);
    }*/
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
