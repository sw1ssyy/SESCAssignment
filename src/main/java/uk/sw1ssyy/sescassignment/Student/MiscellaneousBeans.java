package uk.sw1ssyy.sescassignment.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.sw1ssyy.sescassignment.Model.Course;
import uk.sw1ssyy.sescassignment.Model.Student;
import uk.sw1ssyy.sescassignment.Model.StudentRepo;

import java.util.Set;

@Configuration
public class MiscellaneousBeans {


    @Bean
    CommandLineRunner initDatabase(StudentRepo repo) {
        return args -> {
            Course SESC = new Course();
            SESC.setTitle("SESC");
            SESC.setDescription("Software Engineering for Service Computing");
            SESC.setFee(10.00);

            Course CloudComputing = new Course();
            CloudComputing.setTitle("CloudComputing");
            CloudComputing.setDescription("Service Development on the Cloud");
            CloudComputing.setFee(8.00);

            Course Dissertation = new Course();
            Dissertation.setTitle("Dissertation");
            Dissertation.setDescription("Final Year Project");
            Dissertation.setFee(20.00);

            Student John = new Student();
            John.setFORENAME("John");
            John.setSURNAME("Anderson");
            John.setEXTERNAL_ID("C3537123");
            John.setCoursesEnrolledIn(Set.of(SESC,Dissertation));

            Student Scott = new Student();
            Scott.setFORENAME("Scott");
            Scott.setSURNAME("Su");
            Scott.setEXTERNAL_ID("C3231879");
            Scott.setCoursesEnrolledIn(Set.of(CloudComputing, Dissertation));

            repo.saveAll(Set.of(Scott,John));

        };


    }
}
