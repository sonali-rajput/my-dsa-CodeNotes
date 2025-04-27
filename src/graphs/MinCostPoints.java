package graphs;

import java.util.PriorityQueue;

public class MinCostPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCostPoints obj = new MinCostPoints();
        int ans = obj.minCostConnectPoints(points);
        System.out.println(ans);
    }

    public int minCostConnectPoints(int[][] points) {
     
        int n = points.length;

        // min heap
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        boolean[] inMST = new boolean[n]; // to check for already visited points ( we keep a min spanning tree)

        // start with first point 
        pq.offer(new Point(0,0));

        int minCost = 0;
        int pointsConnected = 0;
        while (pointsConnected < n){
            Point current = pq.poll();
            if(inMST[current.index]){
                continue; // Skip if already present in MST
            }

            inMST[current.index] = true; // mark it as visited
            minCost += current.distance;
            pointsConnected++;

            // Update the priority queue with the remaining points distance in the MST
            for (int i=0; i<n; i++){
                if(!inMST[i]){
                    int distance = Math.abs(points[current.index][0] - points[i][0]) + Math.abs(points[current.index][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }

        return minCost;

    }

    static class  Point {
        int index;
        int distance;

        Point(int index, int distance){
            this.index = index;
            this.distance = distance;
        }  
        
    }
}
