package practice;

public class SearchInsorted {
public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(mininrotatedarr(nums, 0));
    }


     public static int mininrotatedarr(int[] nums, int target){

        int left = 0; 
        int right = nums.length - 1; 

        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            }
        }

        while (left<right){ 
            int mid = left + (right - left)/2; 

            if (target < nums[mid] && target >= nums[left]) { 
            
                right = mid;
            } else if(target > nums[mid] || nums[right] < nums[left]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
