package myy803.statistics;

import myy803.daos.relational.AttendsWithGradeDAO;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkewnessStatisticStrategy extends TemplateStatisticStrategy {

    @Autowired
    public SkewnessStatisticStrategy(AttendsWithGradeDAO attendsWithGradeDAO) {
        super(attendsWithGradeDAO);
    }

    @Override
    public double doActualCalculation(double[] arr) {
        Skewness skewness = new Skewness();
        return skewness.evaluate(arr);
    }

    public String getStatisticStrategyType()
    {
        return "skewness";
    }

}
