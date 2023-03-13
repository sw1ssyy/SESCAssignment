package uk.sw1ssyy.sescassignment.Service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uk.sw1ssyy.sescassignment.Controller.CourseController;
import uk.sw1ssyy.sescassignment.Model.Course;
import uk.sw1ssyy.sescassignment.Model.CourseRepo;

import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CourseService {
    private final CourseRepo repo;

    public CourseService(CourseRepo repo) {

        this.repo = repo;
    }

    private EntityModel<Course> getCourseEntityModel(Course course){
        return EntityModel.of(course,
        linkTo(methodOn(CourseController.class).getCoursebyID(course.getId())).withSelfRel(),
        linkTo(methodOn(CourseController.class).getCoursesJson()).withRel("Courses"));
    }
    public List<Course> getAllCourses(){
        return repo.findAll();
    }

    public List<Course> findCourses(String name){
        return repo.searchCourses(name);
    }

    public CollectionModel<EntityModel<Course>> getAllCoursesJSON(){
        List<EntityModel<Course>> courseList = repo.findAll()
                .stream()
                .map(this::getCourseEntityModel)
                .collect(Collectors.toList());
        return CollectionModel.of(courseList,linkTo(methodOn(CourseController.class)
                .getCoursesJson())
                .withSelfRel());
    }


    public EntityModel<Course> getCourseByIdJson(Long id) {
        Course course = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course with ID: " + id + " not found"));
        return getCourseEntityModel(course);
    }

    public ResponseEntity<EntityModel<Course>> createNewCourseJSON(Course course){
        Course savedCourse = repo.save(course);
        EntityModel<Course> entityModel = getCourseEntityModel(savedCourse);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    public ResponseEntity<EntityModel<Course>> updateCourseJSON(Long id, Course newcourse){
        Course existingCourse = repo.findById(id).orElseThrow(RuntimeException::new);
        existingCourse.setTitle(newcourse.getTitle());
        existingCourse.setDescription(newcourse.getDescription());
        existingCourse.setFee(newcourse.getFee());
        repo.save(existingCourse);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getCourseEntityModel(existingCourse));
    }
}
