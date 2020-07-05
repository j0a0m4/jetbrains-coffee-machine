import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int squared = 1;
        for (int i = 2; squared <= n; i++) {
            System.out.println(squared);
            squared = i * i;
        }
    }
}
