package com.DemoProject.MyLearning.Repository;

import com.DemoProject.MyLearning.Entity.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface StudCourseRepository extends JpaRepository<StudentCourses, Long> {
    /*@Query(value = "SELECT S.*,C.*,SC.REGISTERS,SC.DOJ,SC.STATUS FROM STUDENT S,COURSES C," +
            "STUDENT_COURSES SC WHERE S.STUDENT_ID = SC.STUDENT_ID AND C.COURSE_ID = SC.COURSE_ID AND S.STUDENT_ID = :id",
    nativeQuery = true)*/
    List<StudentCourses> findByStudentStudentId(Long studentId);
    List<StudentCourses> findByCoursesCourseId(Long courseId);

    /*@Query(value = "SELECT S.*,C.*,SC.REGISTERS,SC.DOJ,SC.STATUS FROM STUDENT S,COURSES C,STUDENT_COURSES SC " +
            "WHERE S.STUDENT_ID = SC.STUDENT_ID AND C.COURSE_ID = SC.COURSE_ID AND C.COURSE_ID = :id",
            nativeQuery = true)
    List<StudentCourses> findByCourseId(@Param("id") Long id);*/
}


