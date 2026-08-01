package leetcode75.java21.pratice.p1;

import java.util.*;

public class DFS {
    public static void dfs(
            Map<Integer, List<Integer>> graph,
            int start) {

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println("Visiting node: " + node);
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            System.out.print(node + " ");

            List<Integer> neighbors =
                    graph.getOrDefault(node, List.of());
            System.out.println("Neighbors of " + node + ": " + neighbors);

            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);

                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, List.of(2, 3));
        graph.put(2, List.of(4, 5));
        graph.put(3, List.of(6));
        graph.put(4, List.of());
        graph.put(5, List.of());
        graph.put(6, List.of());

        dfs(graph, 1);
    }
}
