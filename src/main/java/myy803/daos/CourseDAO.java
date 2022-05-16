package myy803.daos;

import myy803.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {

    Course findByCourseName(String courseName);

    void deleteByCourseName(String courseName);
}
