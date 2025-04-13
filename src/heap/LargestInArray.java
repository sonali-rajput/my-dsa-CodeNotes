package heap;

import java.util.PriorityQueue;

public class LargestInArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        LargestInArray obj = new LargestInArray();
        System.out.println(obj.findKthLargest(nums, 2));
    }



    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int n: nums) {
            minHeap.add(n);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }


}
