package myy803.services.relational;

import myy803.entities.relational.Teaches;

import java.util.List;

public interface TeachesService {

    Teaches saveTeaches(Teaches teaches);

    List<Teaches> findAll();

    List<Teaches> findByInstructorUsername(String instructorUsername);

    void deleteByCourseNameAndInstructorUsername(String courseName, String username);
}
