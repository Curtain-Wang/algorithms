package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/23 11:26
 * @Description
 */
public class T322 {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount ; i++) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                //说明能兑换
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1){
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
