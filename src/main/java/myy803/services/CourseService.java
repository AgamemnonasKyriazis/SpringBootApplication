package myy803.services;

import myy803.entities.Course;
import myy803.statistics.StatisticStrategy;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public interface CourseService {

    Course saveCourse(Course course);

    List<Course> findAll();

    Course findByCourseName(String courseName);

    void deleteByCourseName(String courseName);

    Map<String, Double> getCourseStatistics(Course course);

    List<StatisticStrategy> getStatCalculationStrategies();

    void setStatCalculationStrategies(List<StatisticStrategy> statCalculationStrategies);
}
