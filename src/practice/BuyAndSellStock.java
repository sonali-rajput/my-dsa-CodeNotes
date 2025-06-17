package practice;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {2,1,2,1,0,1,2};
        System.out.println(maxProfit(nums));

    }

    public static int maxProfit(int[] nums) {

        int left = 0;
        int right = 1;
        int maxProfit = 0;

        for(int i = 0; i < nums.length-1; i++){
            int profit = nums[right] - nums[left];
            if(profit <= 0){
                left = right;
                right = right + 1;
            }

            else{
                maxProfit = Math.max(profit, maxProfit);
                right = right + 1;
            }
            
        }
        return maxProfit;
    }
}
