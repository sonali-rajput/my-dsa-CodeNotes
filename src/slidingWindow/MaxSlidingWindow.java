package slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k<=0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i=0; i < n; i++) {
            // remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek() < i-k+1) {
                deque.poll();
            }

            // Remove indices whose corresponding values are less than num[i]
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);


            // add the maximum element of the current window to the result
            if (i>=k-1) {
                result[i-k+1] = nums[deque.peek()];
            }
        }
        return result;
    }

}
