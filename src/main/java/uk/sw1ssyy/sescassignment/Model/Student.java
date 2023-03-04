package uk.sw1ssyy.sescassignment.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String EXTERNAL_ID;

    private String FORENAME;

    private String SURNAME;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_to_students",joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> coursesEnrolledIn;


}
