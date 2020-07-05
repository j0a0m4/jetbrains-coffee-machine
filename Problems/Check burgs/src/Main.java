import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        System.out.println(city.endsWith("burg"));
    }
}