package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};

        TaskScheduler obj = new TaskScheduler();
        System.out.println(obj.leastInterval(tasks, 2));

    }


    public int leastInterval(char[] tasks, int n) {
        // Count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(char c: tasks){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        // Build Max-heap based on the frequency Map
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.addAll(freqMap.values());
        

        // Process Tasks
        int time = 0;
        while(!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            for(int i=0; i < n+1; i++) {
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
            }
            // heap must be empty so we reduce value by 1 in templist
            for(int freq: temp) {
                if(--freq > 0) { // we also check that temp list is not having 0 value
                    maxHeap.add(freq); // Adding the temp values back to max-heap
                }
            }

            // Update time
            time += maxHeap.isEmpty()? temp.size(): n+1;
        }

        return time;
    }
}
