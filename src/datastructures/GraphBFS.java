package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {
	 private Map<Integer, List<Integer>> adjList = new HashMap<>();

	    // Add an edge to the graph
	    public void addEdge(int source, int destination) {
	        adjList.putIfAbsent(source, new ArrayList<>());
	        adjList.get(source).add(destination);
	    }

	    // BFS Traversal method
	    public void bfs(int startVertex) {
	        // Standard queue implementation using ArrayDeque
	        Queue<Integer> queue = new ArrayDeque<>();
	        Set<Integer> visited = new HashSet<>();

	        // Enqueue starter node
	        queue.add(startVertex);
	        visited.add(startVertex);

	        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");

	        while (!queue.isEmpty()) {
	            // Dequeue a vertex from the front
	            int currentVertex = queue.poll();
	            System.out.print(currentVertex + " ");

	            // Get all adjacent neighbors of the dequeued vertex
	            if (adjList.containsKey(currentVertex)) {
	                for (int neighbor : adjList.get(currentVertex)) {
	                    // If a neighbor has not been visited, mark visited and enqueue it
	                    if (!visited.contains(neighbor)) {
	                        visited.add(neighbor);
	                        queue.add(neighbor);
	                    }
	                }
	            }
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        GraphBFS graph = new GraphBFS();

	        // Constructing the exact same graph as before
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 4);

	        // Run BFS execution
	        graph.bfs(1); // Output: 1 2 3 4
	    }

}
