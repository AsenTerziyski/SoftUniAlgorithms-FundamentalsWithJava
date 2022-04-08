package _02_CombinatorialProblems;

import java.util.Scanner;

public class _05_VariationsWithRepetitions {

    private static String[] elements;
    private static String[] variations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        variations = new String[k];
        variationsWithRep(0);
    }

    private static void variationsWithRep(int index) {

        if (index == variations.length) {
            print(variations);
        } else {
            for (int i = 0; i < elements.length; i++) {
                variations[index] = elements[i];
                variationsWithRep(index + 1);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join("->", arr));
    }
}
