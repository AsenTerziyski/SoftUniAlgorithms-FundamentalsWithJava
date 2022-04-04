package RecursionAndBacktracking;

import java.util.Scanner;

public class pr02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long result = calculateFactorial(n);
        System.out.println(result);
    }

    private static long calculateFactorial(int n) {
        if (n == 1) {
            return 1L;
        }
        long result = n * calculateFactorial(n - 1);
        System.out.println(result);
        return result;
    }
}
