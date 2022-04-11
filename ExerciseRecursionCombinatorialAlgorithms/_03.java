package _03_ExerciseRecursionCombinatorialAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03 {

    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        arr = new int[k];
        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combinations(index + 1, i);
                // what if i+1???
            }

        }
    }

    private static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
