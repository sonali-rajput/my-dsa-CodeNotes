package linkedLists;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow]; // one jump
            fast = nums[nums[fast]]; // two jump

        }

        // entrance of the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow]; // one jump
            fast = nums[fast]; // one jump
        }

        return fast;
    }

}
