package practice;

public class TrapRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrapRainWater obj = new TrapRainWater();

        int ans = obj.trap(height);

        System.out.println(ans);
    }


    public int trap(int[] height) {
        
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        while (left<right){

            if (height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                 if(leftMax - height[left] > 0){
                totalWater = totalWater + leftMax - height[left];
            }
            left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax - height[right] > 0){
                    totalWater = totalWater + rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;

    }
}
