package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/3 10:18
 * @Description f(i, j) = f(i - 1, j) || f(i - 1, j - a(i))
 */
public class T101 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new T101().canPartition1(nums));
    }
    
    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++){
                dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[nums.length][target];
    }
    
    public boolean canPartition2(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;
        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i % 2][0] = true;
            for (int j = 1; j < target + 1; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] || (j - nums[i - 1] >= 0 && dp[(i - 1) % 2][j - nums[i - 1]]);
            }
        }
        return dp[nums.length % 2][target];
    }
    
    public boolean canPartition3(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = target; j > 0; j--){
                dp[j] = dp[j - 1] || (j - nums[i - 1] > 0 && dp[j - nums[i - 1]]);
            }
        }
        return dp[target];
    }
    
    
    public boolean canPartition1(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2){
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return helper(nums, nums.length, target, dp);
    }
    
    private boolean helper(int[] nums, int i, int j, Boolean[][] dp) {
        if (dp[i][j] == null){
            if (j == 0){
                dp[i][j] = true;
            }else if (i == 0 && j > 0){
                dp[i][j] = false;
            }else {
                dp[i][j] = helper(nums, i - 1, j, dp) || (j - nums[i - 1] >= 0 && helper(nums, i - 1, j - nums[i - 1], dp));
            }
        }
        return dp[i][j];
    }
}
