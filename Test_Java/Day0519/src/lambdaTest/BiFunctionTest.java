package lambdaTest;

import java.util.function.BiFunction;
import java.util.function.Function;
 
public class BiFunctionTest {
    public static void main(String[] args) {
        String male = "남";
        double height = 185.5;
        double weight = 98.5;
        double maleStdWeight = 0;
        String bmiResult = null;
 
        Function<Double, Double> malefunc = (h) -> ((h * h * 0.0001) * 22);
        maleStdWeight = malefunc.apply(height);
 
        System.out.printf("키 %.2fcm인 남성의 표준체중은 %.2f입니다.%n", height, maleStdWeight);
        BiFunction<Double, Double, String> biFunc = (h, w) -> String.format("키 %.2fcm, 몸무게 %.2fcm인 사람의 BMI는 %.2f입니다.%n", h, w,  (w / (h * h * 0.0001)));
 
        bmiResult = biFunc.apply(height, weight);
        System.out.println(bmiResult);
    }
}
