import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {




    }

    private static double FindingAverage(double[] value) {
        double average = 0.0;
        for (int i = 0; i < value.length; i++) {
            average+=value[i];
        }
        return average/ value.length;
    }
}
