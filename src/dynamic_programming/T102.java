package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/3 14:18
 * @Description 
 * p - q = target
 * p + q = sum
 * p = (target + sum) / 2
 * f(i, j) = f(i - 1, j) + f(i - 1, j - nums[i - 1])
 * 
 */
public class T102 {
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        System.out.println(new T102().findTargetSumWays(nums, 2));
    }
    
    private int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target){
            return 0;
        }
        int p = (sum + target) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = p; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[p];
    }
}
