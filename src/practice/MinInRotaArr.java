package practice;

public class MinInRotaArr {

// if left<mid & left<right
//     right = mid - 1; // left = 1, right = 2, mid = 1
// else if right<left & right<mid
//     left = mid+1
// return mid;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(mininrotatedarr(nums));
    }

    public static int mininrotatedarr(int[] nums){

        int left = 0; 
        int right = nums.length - 1; // 5

        while (left<=right){ // l = 0, r = 5

            int mid = left + (right - left)/2; // mid = 2

            if ((nums[left] < nums[mid] && nums[left] < nums[right]) || nums[left] > nums[mid]) { // 
            
                right = mid;
            } else if( nums[right] < nums[left] && nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                return nums[mid];
            }


        }
        return -1;
    }

}
