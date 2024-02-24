package dynamic_programming;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/8/3 14:38
 * @Description
 * int a = num[i - 1]
 * f(i, j) = Math.min(f(i - 1, j), f(i - 1, j - a) + 1, f(i - 1, j - 2a) + 2....)
 */
public class T103 {
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 10};
        System.out.println(new T103().minCoinChange2(nums, 15));
    }
    
    public int minCoinChange(int[] nums, int target){
        int[][] dp = new int[2][target + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] == 0 ? Integer.MAX_VALUE : dp[(i - 1) % 2][j];
                for (int k = 1; k * nums[i - 1] <= j; k++) {
                    dp[i % 2][j] = Math.min(dp[i % 2][j], dp[i % 2][j - k * nums[i - 1]] + k);
                }
            }
        }
        return dp[nums.length % 2][target];
    }
    
    public int minCoinChange1(int[] nums, int target){
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int num : nums) {
            for (int j = target; j >= num; j--){
                for (int k = 1; k * num <= j; k++){
                    dp[j] = Math.min(dp[j], dp[j - k * num] + k);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }
    
    /**
     * f(i) = min(f(i - 1 * num[j]) + 1)
     */
    
    public int minCoinChange2(int[] nums, int target){
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 1; i < target + 1; i++){
            for (int num : nums) {
                if (i >= num){
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[target] == target + 1 ? -1 : dp[target];
    }
}
