package RecursionAndBacktracking;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());

        long counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                counter++;
                System.out.println(counter);
            }
        }
        System.out.println(counter);
    }
}
