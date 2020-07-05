import java.util.*;
import java.util.function.Function;

public class Main {
    static Function<Double, Double> interest = p -> 1 + p / 100;

    public static int calc(double m, double p, double k) {
        int years = 0;
        while (m < k) {
            m = inc(m, p);
            years++;
        }
        return years;
    }

    public static double inc(double m, double p) {
        return m * interest.apply(p);
    }

    public static void main(String[] args) {
        // write your code here
        final Scanner scanner = new Scanner(System.in);
        double m = scanner.nextInt();
        double p = scanner.nextInt();
        double k = scanner.nextInt();
        System.out.println(calc(m, p, k));
    }
}