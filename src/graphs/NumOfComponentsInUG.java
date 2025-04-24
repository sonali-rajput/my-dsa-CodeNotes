package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumOfComponentsInUG {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{1,2},{3,4},{4,5},{3,5}};
        NumOfComponentsInUG obj = new NumOfComponentsInUG();
        int ans = obj.countComponents(n, edges);
        System.out.println(ans);
    }

    public int countComponents(int n, int[][] edges){

        int counter  = 0;
        int[] visited = new int[n]; // for keep track of the nodes

        List<Integer>[] adjList = new ArrayList[n];
        // to form graph
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0 ; i<n; i++){
            if(visited[i] == 0){
                counter++;
                dfs(adjList, visited, i);
            }
        }
        return counter;
    }

    public void dfs(List<Integer>[] adjList, int[] visited, int node) {
        visited[node] = 1; // current node is set to be visited

        for(int i=0; i<adjList[node].size(); i++){
            if(visited[adjList[node].get(i)] == 0){
                dfs(adjList, visited, adjList[node].get(i));
            }
        }

    }
}
