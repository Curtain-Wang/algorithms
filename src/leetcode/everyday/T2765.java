package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2024/1/23 10:36
 * @Description 最长交替子数组
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 */
public class T2765 {
    
    public static void main(String[] args) {
        System.out.println(new T2765().alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }
    
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if ((nums[right] - nums[right - 1] == 1 && right - left % 2 == 1) || (nums[right] - nums[left] == -1 && right - left % 2 == 0)) {
                right++;
            } else {
                if (right - left > 1) {
                    ans = Math.max(ans, right - left + 1);
                }
                left = right;
                right++;
            }
        }
        return ans;
    }
}
