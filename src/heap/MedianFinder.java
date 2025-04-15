package heap;

import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(7);
        obj.addNum(5);
        obj.addNum(2);
        double ans = obj.findMedian();
        System.out.println(ans);


    }

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll()); // balancing step

        if(maxHeap.size()<minHeap.size()) { // maintain size propert (maxHeap can have +1 elements)
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) *0.5;
    }
}
