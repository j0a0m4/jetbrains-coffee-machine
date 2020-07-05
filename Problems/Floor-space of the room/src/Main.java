import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static double calculate(String roomType) {
        double a, b, c, r, res = 0;
        switch (roomType){
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                res = calculateRectangle(a, b);
                break;
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                res = calculateTriangle(a,b,c);
                break;
            case "circle":
                r = scanner.nextDouble();
                res = calculateCircle(r);
                break;
        }
        return res;
    }

    private static double calculateCircle(double r) {
        return 3.14 * Math.pow(r, 2);
    }

    private static double calculateTriangle(double a, double b, double c) {
        Double p = (a + b + c) * 0.5;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static double calculateRectangle(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        // put your code here
        String roomType = scanner.nextLine();
        double res = calculate(roomType);
        System.out.println(res);
    }
}