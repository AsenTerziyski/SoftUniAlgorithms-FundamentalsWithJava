package demoes;

import java.util.ArrayList;
import java.util.List;

public class xx_demoGraph02 {

    public static class Edge {
        public int source;
        private int destinations;

        public Edge(int source, int destinations) {
            this.source = source;
            this.destinations = destinations;
        }
    }

    public static void main(String[] args) {

//        int nodes = 10;
//        int[][] graph = new int[10][10];
        // because nodes start from 1 , the matrix will be with length nodes+1:
//        int[][] graph = new int[nodes + 1][nodes + 1];

        // 3 -> 6 => node 3 has connection with node 6;


        // 1 -> 2, 3, 4, 5, 6
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(1, 2));
        graph.add(new Edge(1, 3));
        graph.add(new Edge(1, 4));
        graph.add(new Edge(1, 5));
        graph.add(new Edge(1, 6));


    }
}
