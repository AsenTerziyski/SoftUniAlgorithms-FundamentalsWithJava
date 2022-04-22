package demoes;

import java.util.ArrayList;
import java.util.Arrays;

public class xx_demoGraph01 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//        graph.add(new ArrayList<>());
//        graph.add(new ArrayList<>());
//        graph.add(new ArrayList<>());
//        graph.add(new ArrayList<>());
//        graph.add(3, new ArrayList<>());
//        graph.get(3).add(1);
        for (int i = 0; i < 10 + 1; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).addAll(Arrays.asList(9, 8, 5));
        graph.get(9).add(1);
        graph.get(8).add(1);
        graph.get(5).add(1);
        graph.get(2).add(10);
        graph.get(3).add(1);

        for (Integer child : graph.get(1)) {
            System.out.println(child);
        }

        System.out.println();

        for (Integer child : graph.get(9)) {
            System.out.println(child);
        }

    }
}
