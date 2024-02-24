package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/3 10:58
 * @Description
 */
public class T136 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
