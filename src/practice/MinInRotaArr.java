package practice;

public class MinInRotaArr {

// if left<mid & left<right
//     right = mid - 1; // left = 1, right = 2, mid = 1
// else if right<left & right<mid
//     left = mid+1
// return mid;

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(mininrotatedarr(nums));
    }

    public static int mininrotatedarr(int[] nums){

        int left = 0; 
        int right = nums.length - 1; //

        while (left<=right){

            int mid = left + (right - left)/2;

            if (nums[left] < nums[mid] && nums[left] < nums[right]){
                right = mid - 1;
            } else if( nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                return nums[mid];
            }


        }
        return -1;
    }

}
