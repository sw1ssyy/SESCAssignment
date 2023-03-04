package uk.sw1ssyy.sescassignment.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double fee;

    @ManyToMany(mappedBy = "coursesEnrolledIn")
    @JsonIgnore
    Set<Student> StudentsEnrolledInCourses;
}
