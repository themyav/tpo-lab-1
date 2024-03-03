package task1;

public class AtanTailorSummator {
    public static double getSum(double x, int n){
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / (2 * i + 1);
        }
        return sum;
    }
}
