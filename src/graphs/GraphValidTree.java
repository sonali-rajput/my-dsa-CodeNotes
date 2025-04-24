package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GraphValidTree {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1},{0,2},{2,3}};
        GraphValidTree obj = new GraphValidTree();
        boolean ans = obj.validTree(n, edges);
        System.out.println(ans);
    }

    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){ // nodes = n, edges = n-1 if not that means cycle present
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        // vertices
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        // for edges
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); // cuz edges are undirected
        }

        // iterate over the adjList(graph) using dfs (stack) approach
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour: adjList.get(node)){
                // ignore if neighbour already been visited
                if(visited.contains(neighbour)){
                    continue;
                }
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }
        // checking if all nodes are connected
        if(visited.size() == n){
            return true;
        }
        return false;

    }

}
