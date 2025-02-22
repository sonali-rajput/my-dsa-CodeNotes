package arrays;

public class RemoveDuplicateTwoPointer {

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1;fast<nums.length; fast++){
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }

}
