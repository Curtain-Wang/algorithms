package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/7/31 15:21
 * @Description f(i, j) = f(j, k) + 1
 */
public class T93 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(new T93().lenLongestFibSubseq(nums));
    }
    
    private int lenLongestFibSubseq(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[][] dp = new int[nums.length][nums.length];
        int result = 2;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                Integer k = map.getOrDefault(nums[i] - nums[j], -1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }
}
