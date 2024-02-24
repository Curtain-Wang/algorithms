package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/24 9:19
 * @Description 掷骰子等于目标和的方法数
 */
public class T1155 {
    
    public static void main(String[] args) {
        System.out.println(new T1155().numRollsToTarget(30, 30, 500));
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        if (n > target){
            return 0;
        }
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= (i * k > target ? target : i * k); j++) {
                for (int l = 1; l <= k && l < j; l++) {
                    dp[i][j] += dp[i - 1][j - l];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n][target];
    }
    
}
