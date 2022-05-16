package myy803.statistics;

import myy803.daos.relational.AttendsWithGradeDAO;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeanStatisticStrategy extends TemplateStatisticStrategy {

    @Autowired
    public MeanStatisticStrategy(AttendsWithGradeDAO attendsWithGradeDAO) {
        super(attendsWithGradeDAO);
    }

    @Override
    public double doActualCalculation(double[] arr) {
        Mean mean = new Mean();
        return mean.evaluate(arr);
    }

    public String getStatisticStrategyType()
    {
        return "mean";
    }
}
