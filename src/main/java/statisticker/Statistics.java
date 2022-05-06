package statisticker;

import java.util.List;
import java.util.OptionalDouble;

public class Statistics 
{
    static class Stats {

        public float average;
        public float min;
        public float max;

        public Stats(float average, float min, float max) {
            this.average = average;
            this.min = min;
            this.max = max;
        }
    }
    public static Stats getStatistics(List<Float> numbers) {
        //implement the computation of statistics here
        if(numbers==null || numbers.isEmpty()){
            return new Stats(Float.NaN,Float.NaN,Float.NaN);
        }
        float average  = (float)numbers.stream().mapToDouble(a->a).average().getAsDouble();
        float min  = (float)numbers.stream().mapToDouble(a->a).min().getAsDouble();
        float max  = (float)numbers.stream().mapToDouble(a->a).max().getAsDouble();
        return new Stats(average,min,max);
    }
}
