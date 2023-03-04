package uk.sw1ssyy.sescassignment.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.sw1ssyy.sescassignment.Model.Course;
import uk.sw1ssyy.sescassignment.Service.CourseService;

import java.util.List;

@Controller
public class CourseController {
    private CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }


    @GetMapping("/Courses")

    public ModelAndView getCourses(){
        List<Course> courseList = service.getAllCourses();
        ModelAndView modelview = new ModelAndView("courses");
        modelview.addObject("courses", courseList);
        return modelview;
    }
}
