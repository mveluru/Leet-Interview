package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDFS {
	private Map<Integer, List<Integer>> adjList = new HashMap<>();
	
	public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(destination);
    }
	
	public void printAdjList(){
		System.out.println(this.adjList);
	}
	
	 // Helper method for DFS recursion
    private void dfsHelper(int vertex, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        if (adjList.containsKey(vertex)) {
            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }
	
	// Main DFS method
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
    }
	
	public static void main(String[] args) {
		GraphDFS graph = new GraphDFS();
		
		 // Constructing a sample graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        
        graph.printAdjList();

        System.out.print("DFS Traversal starting from vertex 1: ");
        graph.dfs(1); // Output: 1 2 4 3
		
	}

}
