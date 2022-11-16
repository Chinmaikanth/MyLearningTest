package com.DemoProject.MyLearning.Repository;

import com.DemoProject.MyLearning.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long > {
    //Courses findByCourseId(int courseId);
}
