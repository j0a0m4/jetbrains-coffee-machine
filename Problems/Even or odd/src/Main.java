
import java.util.Scanner;
import java.util.function.Predicate;

class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input != 0) {
            if (isEven.test(input)) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
            input = scanner.nextInt();
        }
    }
}