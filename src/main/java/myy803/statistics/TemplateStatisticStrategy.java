package myy803.statistics;

import myy803.daos.relational.AttendsWithGradeDAO;
import myy803.entities.Course;
import myy803.entities.relational.AttendsWithGrade;

import java.util.List;

public abstract class TemplateStatisticStrategy implements StatisticStrategy {

    private AttendsWithGradeDAO attendsWithGradeDAO;

    public TemplateStatisticStrategy(AttendsWithGradeDAO attendsWithGradeDAO) {
        this.attendsWithGradeDAO = attendsWithGradeDAO;
    }

    public double calculateStatistic(Course course) {
        double[] courseGrades = prepareDataSet(course);
        return doActualCalculation(courseGrades);
    }

    private double[] prepareDataSet(Course course) {
        List<AttendsWithGrade> attendsWithGradeList = attendsWithGradeDAO.findByAttendsWithGradeIdCourseName(course.getCourseName());
        double[] courseGrades = new double[attendsWithGradeList.size()];
        int i = 0;
        for(AttendsWithGrade attendsWithGrade : attendsWithGradeList)
        {
            courseGrades[i] = attendsWithGrade.getGrade();
            i++;
        }
        return courseGrades;
    }

    public abstract double doActualCalculation(double[] arr);

    public abstract String getStatisticStrategyType();
}
