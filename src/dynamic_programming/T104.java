package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/3 19:52
 * @Description
 * f(i) = f(i - nums[0 - n])
 */
public class T104 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new T104().permutationSum(nums, 4));
    }
    
    
    private int permutationSum(int[] nums, int target){
        int [] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++){
            for (int num : nums) {
                if (i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
