package uk.sw1ssyy.sescassignment.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
@Query("SELECT c from Course c WHERE " +
        "c.title LIKE CONCAT('%',:name,'%')")

    List<Course> searchCourses(String name);

}
