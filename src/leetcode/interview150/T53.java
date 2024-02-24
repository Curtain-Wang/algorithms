package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/21 20:19
 * @Description
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
