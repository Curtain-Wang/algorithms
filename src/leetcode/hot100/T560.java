package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/8/14 13:09
 * @Description 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 
 * 示例 2： 
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * f(i, j) = f(i - 1, j - nums[i]) + f(i - 1, j);
 */
public class T560 {
    
    public static void main(String[] args) {
        int[] sums = {1, 1, 1};
        System.out.println(new T560().subarraySum(sums, 1));
    }
    
    /**
     * 前缀和+哈希
     * preSum - k 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k){
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int target = preSum - k;
            count += preSumMap.getOrDefault(target, 0);
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
    
    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int[] preSums = new int[nums.length + 1];
        preSums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
        int result = 0;
        for (int left = 0; left < nums.length; left++){
            for (int right = left; right < nums.length; right++){
                if (preSums[right + 1] - preSums[left] == k){
                    result++;
                }
            }
        }
        return result;
    }
    
    
}
