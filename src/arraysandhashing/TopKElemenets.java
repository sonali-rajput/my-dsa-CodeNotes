package arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKElemenets {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKElemenets obj = new TopKElemenets();
        int[] answer = obj.topKFrequent(nums, k);
        System.out.println(Arrays.toString(answer));
    }

    public int[] topKFrequent(int[] nums, int k) {
     
        if(nums.length == 0){
            return null;
        }

        if(k == nums.length){
            return nums;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> count.get(a) - count.get(b)
        );

        for(int n: count.keySet()){
            minHeap.add(n);
            if( minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i <k; i++){
            ans[i]=minHeap.poll();
        }
        return ans;
    }
}
