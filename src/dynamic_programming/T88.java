package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/7/26 10:50
 * @Description
 */
public class T88 {
    
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 100, 1};
        System.out.println(new T88().minCostClimbingStairs4(cost));
    }
    
    private int minCostClimbingStairs(int[] cost){
        int length = cost.length;
        return Math.min(helper(cost, length - 1), helper(cost, length - 2));
    }
    
    private int helper(int[] cost, int i) {
        if (i < 2){
            return cost[i];
        }
        return Math.min(helper(cost, i - 1), helper(cost, i - 2)) + cost[i];
    }
    
    private int minCostClimbingStairs1(int[] cost){
        int length = cost.length;
        int[] dp = new int[length];
        helper1(cost, length - 1, dp);
        return Math.min(dp[length - 1], dp[length - 2]);
    }
    
    private void helper1(int[] cost, int i, int[] dp) {
        if (i < 2){
            dp[i] = cost[i];
        }else if (dp[i] == 0){
            helper1(cost, i - 1, dp);
            helper1(cost, i - 2, dp);
            dp[i] = Math.min(dp[i - 1] , dp[i - 2]) + cost[i];
        }
    }
    
    private int minCostClimbingStairs3(int[] cost){
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
    
    private int minCostClimbingStairs4(int[] cost){
        int[] dp = {cost[0], cost[1]};
        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
