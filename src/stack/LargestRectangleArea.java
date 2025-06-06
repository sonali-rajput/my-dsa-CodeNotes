package stack;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3,};
        System.out.println(largestRectangleArea(height));
    }


    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length; // 6

        for(int i=0; i<=n; i++){ // i = 6
            int currentHeight = (i==n)? 0:heights[i]; // crr = 0
            while(!stack.isEmpty() && currentHeight< heights[stack.peek()]) {
                int height = heights[stack.pop()]; // h = 5;
                int width  = stack.isEmpty() ? i: i-stack.peek() - 1; // w = 2
                maxArea = Math.max(maxArea, height*width); // max = 10
            }
            stack.push(i); // 1,4,5
        }
        return maxArea;
    }
}
