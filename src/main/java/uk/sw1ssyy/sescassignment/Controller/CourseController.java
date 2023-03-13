package uk.sw1ssyy.sescassignment.Controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.sw1ssyy.sescassignment.Model.Course;
import uk.sw1ssyy.sescassignment.Service.CourseService;

import java.util.List;

@Controller
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }


    @GetMapping("/Courses")

    public ModelAndView ShowAllCourses() {
        List<Course> courseList = service.getAllCourses();
        ModelAndView modelview = new ModelAndView("courses");
        modelview.addObject("courses", courseList);
        return modelview;
    }
    @GetMapping("Courses/Search")
    public ModelAndView ShowSearchedCourse(@RequestParam("name") String name){
        List<Course> courseList = service.findCourses(name);
        ModelAndView  modelAndView = new ModelAndView("CourseSearch");
        modelAndView.addObject("results", courseList);
        return modelAndView;

    }
@GetMapping("/api/Courses")
@ResponseBody
    public CollectionModel<EntityModel<Course>> getCoursesJson() {
        return service.getAllCoursesJSON();
    }
    @GetMapping("/api/Courses/{id}")
    @ResponseBody
    public EntityModel<Course>getCoursebyID(@PathVariable Long id){
        return service.getCourseByIdJson(id);
    }

    @PostMapping("/api/Courses")
     ResponseEntity<EntityModel<Course>> createCourseJSON(@RequestBody  Course newCourse){return service.createNewCourseJSON(newCourse);

    }
    @PutMapping("/api/Courses/{id}")
    ResponseEntity<?>editCourseJSON(@PathVariable Long id, @RequestBody Course newCourse){
        return service.updateCourseJSON(id,newCourse);
    }
}
