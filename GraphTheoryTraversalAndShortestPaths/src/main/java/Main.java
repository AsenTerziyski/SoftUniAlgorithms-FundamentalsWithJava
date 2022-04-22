import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("START....");
            // PROBLEM 01
//        Scanner scanner = new Scanner(System.in);

//        int n = Integer.parseInt(scanner.nextLine());
//        List<List<Integer>> graph = new ArrayList<>();
//
//        // fill the graph:
//        for (int i = 0; i < n; i++) {
//            String nextLine = scanner.nextLine();
//            if (!nextLine.isBlank()) {
//                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());
//                graph.add(nextNodes);
//            } else {
//                graph.add(new ArrayList<>());
//            }
//        }

//        getConnectedComponents(graph);

        // PROBLEM 02
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("D", "E")));
        graph.put("C", new ArrayList<>(Arrays.asList("F")));
        graph.put("D", new ArrayList<>(Arrays.asList("C", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>());
        topSort(graph);

        System.out.println("......END");
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
//        throw new AssertionError("Not Implemented");
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();
        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
//                dfs(start, components, graph, visited);
                bfs(start, components, graph, visited);
            }
        }

        for (Deque<Integer> component : components) {
            System.out.print("Connected component: ");
            for (Integer integer : component) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        return components;
    }

    private static void bfs(int start, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            components.get(components.size() - 1).offer(node);
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }

            }
        }
    }

//    private static void dfs(int node, List<Deque<Integer>> components,
//                            List<List<Integer>> graph,
//                            boolean[] visited) {
//        if (!visited[node]) {
//            visited[node] = true;
//            for (int child : graph.get(node)) {
//                dfs(child, components, graph, visited);
//            }
//            components.get(components.size() - 1).offer(node);
//        }
//
//    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
////        throw new AssertionError("Not Implemented");
        // Първи начин:
//        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);
//
//        List<String> sorted = new ArrayList<>();
//        while (!graph.isEmpty()) {
//            String key = graph.keySet().stream()
//                    .filter(k -> dependenciesCount.get(k) == 0)
//                    .findFirst()
//                    .orElse(null);
//
//            if (key == null) {
//                break;
//            }
//
//            // след като махна възела, трябва да разкача децата му и да намаля техните  dependencies:
//            List<String> children = graph.get(key);
//            for (String child : children) {
//                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
//            }
//
//            sorted.add(key);
//            graph.remove(key);
//        }
//
//        if (!graph.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//
//        return sorted;

        // Втори начин:
        List<String> sorted = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> detectCycles = new HashSet<>();
        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            String key = node.getKey();
            dfs(key, visited, graph, sorted, detectCycles);
        }

//        Collections.sort(sorted);
        Collections.reverse(sorted);
        return sorted;

    }

    private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph,
                            List<String> sorted,
                            Set<String> detectCycles) {

        if (detectCycles.contains(key)) {
            throw new IllegalArgumentException();
        }

        if (!visited.contains(key)) {
            visited.add(key);
            //Преди да извикам рекурсията добавям child
            detectCycles.add(key);
            for (String child : graph.get(key)) {
                dfs(child, visited, graph, sorted, detectCycles);
            }
            //След извикването й - махам child
            detectCycles.remove(key);
            sorted.add(key);
        }

    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        // LinkedHashMap, because is important the order:
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> nodeEntry : graph.entrySet()) {
            dependenciesCount.putIfAbsent(nodeEntry.getKey(), 0);
            for (String child : nodeEntry.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }

        }

        return dependenciesCount;
    }
}
