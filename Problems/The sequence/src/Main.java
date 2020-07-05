import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int count = 0;
        for (int i = 1; count < n; i++) {
            for (int k = 0; k < i; k++) {
                if (count < n) {
                    System.out.print(i + " ");
                }
                count++;
            }
        }
    }
}