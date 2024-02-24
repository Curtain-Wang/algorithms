package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/7/26 15:23
 * @Description
 */
public class T89 {
    
    public static void main(String[] args) {
        int[] a = {2,3,4,5,3};
        System.out.println(new T89().rob1(a));
    }
    
    
    private int rob(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = {nums[0], Math.max(nums[0], nums[1])};
        for (int i = 2; i < nums.length; i++){
            int temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
    
    private int rob1(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = dp[0][(i - 1) % 2] + nums[i];
        }
        return Math.max(dp[0][(nums.length - 1) % 2], dp[1][(nums.length - 1) % 2]);
    }
}
