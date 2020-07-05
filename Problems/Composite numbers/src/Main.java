import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    static Predicate<Long> isPositive = n -> n > 0;
    static Predicate<Long> isPrime = n -> {
        boolean flag = true;
        for (long i = 2L; i < n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    };

    public static boolean isComposite(long number) {
        // write your code here
        return isPositive.test(number) && !isPrime.test(number);
    }


    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}