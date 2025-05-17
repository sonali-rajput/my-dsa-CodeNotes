package practice;

public class MostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        MostWater obj = new MostWater();
        int ans = obj.maxArea(height);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxarea = 0;

        while (left < right) {

            int width = right - left;
            int area;
            if (height[left] <= height[right]) {
                area = height[left] * width;
                
                left++;
            }
            else {
                area = height[right]*width;
                right--;
            }
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }

}
