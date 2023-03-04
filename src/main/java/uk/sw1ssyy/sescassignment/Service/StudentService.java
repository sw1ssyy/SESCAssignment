package uk.sw1ssyy.sescassignment.Service;

import org.springframework.stereotype.Component;
import uk.sw1ssyy.sescassignment.Model.Student;
import uk.sw1ssyy.sescassignment.Model.StudentRepo;

import java.util.List;
@Component
public class StudentService {
    private StudentRepo repo;

    public StudentService(StudentRepo repo) {

        this.repo = repo;
    }
    public List<Student> getAllStudents(){

        return repo.findAll();
    }
}
