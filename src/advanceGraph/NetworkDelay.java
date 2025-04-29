package advanceGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelay {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        NetworkDelay obj = new NetworkDelay();
        int ans = obj.networkDelayTime(times, n, k);
        System.out.println(ans);
    }

    public int networkDelayTime(int[][] times, int n, int k){


        // crate graph using adjacency list
        Map<Integer,List<int[]>> graph = new HashMap<>();
        
        // times = {2,4,1} = from node 2 to node 4 it takes 1 minute, key is node 1 and value is (node2,weight)
        for(int[] edge: times){
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]}); 
        }

        // Priority Queue to select the node with the min distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // min-heap
        pq.offer(new int[]{k, 0}); // start from node k with a distance of 0 (node 2 to node 2 distance is 0)

        // Initialize distances of all nodes in array with infinity
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0; // distance to itself is 0

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentNode = current[0]; // node
            int currentDist = current[1]; // distance

            // if we already found a shorter path before then continue
            if (currentDist > distances[currentNode]){
                continue;
            }

            // Update the distances of neighbouring nodes
            if (graph.containsKey(currentNode)) {
                for(int[] neighbour: graph.get(currentNode)) {
                    int nextNode = neighbour[0];
                    int nextDist = currentDist + neighbour[1];
                    if (nextDist<distances[nextNode]) {
                        distances[nextNode] = nextDist;
                        pq.offer(new int[]{nextNode, nextDist});
                    }
                }
            }
        }

        // Find the maximum distance from the source node (k) to all other nodes
        int maxDist = Arrays.stream(distances).skip(1).max().getAsInt(); // skiping 1 cuz we taking n+1 array size
        return maxDist == Integer.MAX_VALUE ? -1: maxDist;


    }
}
