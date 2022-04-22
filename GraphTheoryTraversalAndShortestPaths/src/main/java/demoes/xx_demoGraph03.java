package demoes;

import java.util.ArrayList;
import java.util.List;

public class xx_demoGraph03 {
    public static class Graph {
        int source;
        List<Edge> edges;

        public Graph(int source) {
            this.source = source;
            this.edges = new ArrayList<>();
        }
    }

    public static class Edge {
        public int source;
        private int destinations;

        public Edge(int source, int destinations) {
            this.source = source;
            this.destinations = destinations;
        }
    }

    public static void main(String[] args) {
        // 1 -> 2, 3, 4, 5, 6
        Graph graph = new Graph(1);
        graph.edges.add(new Edge(1, 2));


    }
}
