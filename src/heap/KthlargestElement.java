package heap;

import java.util.PriorityQueue;

public class KthlargestElement {

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
    KthlargestElement obj = new KthlargestElement(3, nums);
    int o1 = obj.add(3);
    System.out.println(o1);
    int o2 = obj.add(5);
    System.out.println(o2);
    }
    


    private PriorityQueue<Integer> minHeap;
    private int k;

    public  KthlargestElement(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // min heap with a size of k

        // Add initial elements to the heap
        for(int n: nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k) {
            minHeap.offer(val);

        }else if (val>minHeap.peek()) { // the new val (or value already in nums) if it is greater than head of queue, then we remove the head.
            minHeap.poll(); // remove the smallest element
            minHeap.offer(val); // add the new value in queue


        }

        return minHeap.peek(); // return the kth largest element in the priority queues(min-heap)
        
    }

}
