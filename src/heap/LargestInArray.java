package heap;

import java.util.PriorityQueue;

public class LargestInArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        LargestInArray obj = new LargestInArray();
        System.out.println(obj.findKthLargest(nums, 2));
    }



    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a); // comparator 

        for(int num: nums) {
            maxHeap.add(num);
        }

        for(int i=0;i<k-1;i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }


}
