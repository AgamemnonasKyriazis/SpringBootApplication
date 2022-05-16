package myy803.services;

import myy803.daos.CourseDAO;
import myy803.entities.Course;
import myy803.statistics.StatisticStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private List<StatisticStrategy> statCalculationStrategies;

    @Qualifier("meanStatisticStrategy")
    @Autowired
    private StatisticStrategy meanStatisticStrategy;

    @Qualifier("skewnessStatisticStrategy")
    @Autowired
    private StatisticStrategy skewnessStatisticStrategy;

    public CourseServiceImpl() {

    }

    @Override
    public Map<String, Double> getCourseStatistics(Course course) {
        Map<String, Double> courseStatistics = new HashMap();
        double mean = meanStatisticStrategy.calculateStatistic(course);
        double skewness = skewnessStatisticStrategy.calculateStatistic(course);
        courseStatistics.put("mean", mean);
        courseStatistics.put("skewness", skewness);
        return courseStatistics;
    }

    @Override
    public List<StatisticStrategy> getStatCalculationStrategies() {
        return this.statCalculationStrategies;
    }

    @Override
    public void setStatCalculationStrategies(List<StatisticStrategy> statCalculationStrategies) {
        this.statCalculationStrategies = statCalculationStrategies;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseDAO.save(course);
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    @Transactional
    public Course findByCourseName(String courseName) {
        return courseDAO.findByCourseName(courseName);
    }

    @Override
    @Transactional
    public void deleteByCourseName(String courseName) {
        courseDAO.deleteByCourseName(courseName);
    }
}
