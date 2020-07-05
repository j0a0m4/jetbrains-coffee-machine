import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner
                .nextLine()
                .trim()
                .replace(" ", "");
        String str2 = scanner
                .nextLine()
                .trim()
                .replace(" ", "");
        System.out.println(str1.equals(str2));
    }
}