package _02_CombinatorialProblems;

import java.util.Scanner;

public class _01_PermutationsWithoutRepetitions {

    private static String[] elements;
    private static String[] permutes;
    // if Boolean => will asign nulls, else if boolean => will assign false:
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        permutes = new String[elements.length];
        used = new boolean[elements.length];
        System.out.println();


        permute(0);
    }

    private static void permute(int index) {

        if (index == elements.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutes[index] = elements[i];
                permute(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permutes));
    }


}
