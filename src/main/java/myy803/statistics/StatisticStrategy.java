package myy803.statistics;

import myy803.entities.Course;

public interface StatisticStrategy {

        double calculateStatistic(Course course);

        String getStatisticStrategyType();
}
