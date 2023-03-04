package uk.sw1ssyy.sescassignment.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.sw1ssyy.sescassignment.Model.Student;
import uk.sw1ssyy.sescassignment.Service.StudentService;

import java.util.List;
@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/Students")
    public ModelAndView getCourses(){
        List<Student> studentList = service.getAllStudents();
        ModelAndView modelview = new ModelAndView("students");
        modelview.addObject("students", studentList);
        return modelview;
    }
}
