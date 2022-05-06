package statisticker;

import java.util.Arrays;
import java.util.List;

public class StatsChecker {

    IAlerter alerters[] ;
    float maxThreshold ;
    
    public StatsChecker(float maxThreshold, IAlerter[] alerters) {
        this.alerters = alerters;
        this.maxThreshold=maxThreshold;
    }

    public void checkAndAlert(Float[] numbers) {
        List<Float> numberList = Arrays.asList(numbers);
        float maxVal  = (float)numberList.stream().mapToDouble(a->a).max().getAsDouble();
        if(maxVal>maxThreshold){
            EmailAlert emailAlert = (EmailAlert) alerters[0];
            emailAlert.emailSent=true;
            LEDAlert ledAlert = (LEDAlert) alerters[1];
            ledAlert.ledGlows=true;
        }

    }
}
