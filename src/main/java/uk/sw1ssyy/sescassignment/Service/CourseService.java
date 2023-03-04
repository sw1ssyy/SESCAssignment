package uk.sw1ssyy.sescassignment.Service;

import org.springframework.stereotype.Component;
import uk.sw1ssyy.sescassignment.Model.Course;
import uk.sw1ssyy.sescassignment.Model.CourseRepo;

import java.util.List;

@Component
public class CourseService {
    private CourseRepo repo;

    public CourseService(CourseRepo repo) {

        this.repo = repo;
    }
    public List<Course> getAllCourses(){
        return repo.findAll();
    }

}
