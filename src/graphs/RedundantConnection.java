package graphs;

import java.util.Arrays;

public class RedundantConnection {


    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        RedundantConnection obj = new RedundantConnection();
        int[] ans = obj.findRedundantConnection(edges);
        System.out.println(Arrays.toString(ans));
    }

    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length - 1];
        for(int i=1; i<= edges.length; i++){
            parent[i] = i; // each node is its own parent (Nodes are individual sets of their own)
        }

        // iterate through the edge to find the redundant one
        for (int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];

            // Find roots of node1 and node2
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            // if roots same, a cycle is detected and we return the current edge
            if(root1 == root2){
                return edge;
            }

            // Union(merge) the sets by making root1 the parent of root2
            parent[root2] = root1;
        }
        // if no cycle is found , return empty
        return new int[0];

    }


    private static int find(int[] parent, int node){
        while(node != parent[node]) {
            parent[node] = parent[parent[node]]; // Path compression for optimization
            node = parent[node];
        }
        return node;
    }
}
