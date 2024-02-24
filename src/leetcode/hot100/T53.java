package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/18 11:16
 * f(i) =  max(f(i - 1) + nums[i], nums[i]))
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int result = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = dp > 0 ? dp + nums[i] : nums[i];
            result = Math.max(result, dp);
        }
        return result;
    }
}
