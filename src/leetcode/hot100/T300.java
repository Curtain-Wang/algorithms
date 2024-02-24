package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/23 11:35
 * @Description
 */
public class T300 {
    
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(new T300().lengthOfLIS(nums));
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
