package heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(obj.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        
        // create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        // Add all stones in the heap
        for(int stone: stones){
            maxHeap.add(stone);
        }

        // continuouslt remove and smash the two heaviest stones
        while(maxHeap.size()>1) {
            int y = maxHeap.poll(); // The first heaviest stone
            int x = maxHeap.poll(); // second heaviest stone

            if(x != y) {
                maxHeap.add(y-x); 
            }
        }
        return maxHeap.isEmpty()? 0:maxHeap.poll(); 
    }

}
