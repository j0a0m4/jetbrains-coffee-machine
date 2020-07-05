import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static boolean checkAsc(List<Integer> nums) {
        var ordered = true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (ordered) {
                int cur = nums.get(i);
                int next = nums.get(i + 1);
                if (cur > next) {
                    ordered = false;
                }
            } else {
                break;
            }
        }
        return ordered;
    }

    public static boolean checkDesc(List<Integer> nums) {
        var ordered = true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (ordered) {
                int cur = nums.get(i);
                int next = nums.get(i + 1);
                if (cur < next) {
                    ordered = false;
                }
            } else {
                break;
            }
        }
        return ordered;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        int input = scanner.nextInt();
        while (input != 0) {
            nums.add(input);
            input = scanner.nextInt();
        }
        System.out.println(checkAsc(nums) || checkDesc(nums));
    }
}