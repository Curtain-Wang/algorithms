package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/11/15 9:27
 * @Description
 */
public class T2656 {
    
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max * k + (0 + k - 1) * k / 2;
    }
}
