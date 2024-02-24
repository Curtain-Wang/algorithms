package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/7/26 17:09
 * @Description
 */
public class T90 {
    
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,3};
        System.out.println(new T90().rob(nums));
    }
    
    private int rob(int[] nums){
        int length = nums.length;
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int a = helper(nums, 0, length - 2);
        int b = helper(nums, 1, length - 1);
        return Math.max(a, b);
    }
    
    private int helper(int[] nums, int start, int end) {
        if (nums.length == start){
            return nums[start];
        }
        int[] dp = new int[2];
        dp[start % 2] = nums[start];
        dp[(start + 1) % 2] = nums[start + 1];
        for (int i = start + 2; i <= end; i++) {
            dp[i % 2] = Math.max(dp[i % 2] + nums[i], dp[(i - 1) % 2]);
        }
        return dp[end % 2];
    }
}
