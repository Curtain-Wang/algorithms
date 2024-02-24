package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/21 20:25
 * @Description
 */
public class T918 {
    public static void main(String[] args) {
        System.out.println(new T918().maxSubarraySumCircular(new int[]{5, -3, 5}));
    }
    
    public int maxSubarraySumCircular(int[] nums) {
        //先求f0的值
        int maxS = Integer.MIN_VALUE;
        int minS = Integer.MAX_VALUE;
        int sum = 0;
        int maxF = 0, minF = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxF = Math.max(maxF, 0) + nums[i];
            minF = Math.min(minF, 0) + nums[i];
            maxS = Math.max(maxS, maxF);
            minS = Math.min(minF, minS);
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }
}
