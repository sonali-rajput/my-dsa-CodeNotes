package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KclosestPoints {

    public static void main(String[] args) {
        KclosestPoints obj = new KclosestPoints();
        int[][] points = {{1,3},{-2,2}};
        System.out.println(Arrays.deepToString(obj.kClosest(points, 1)));
    }
    
    
    public int[][] kClosest(int[][] points, int k) {
        
        // Create a max-heap based on the distance from the origin (using euclidean's formula)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        );

        // Add points to the heap and remove the farthest points if heap size exceeds k
        for(int[] point: points) {
            maxHeap.add(point);
            if(maxHeap.size()>k) {
                maxHeap.poll();
            }
        }

        // Collect k closes points from the heap
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
