package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/7/28 17:16
 * @Description
 */
public class T91 {
    
    public static void main(String[] args) {
        int[][] cost = {{17, 2, 16}, {15,14,5},{13,3,1}};
        System.out.println(new T91().minCost(cost));
    }
    
    private Integer minCost(int[][] cost){
        if (cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return Math.min(Math.min(cost[0][0], cost[0][1]), cost[0][2]);
        }
        int[][] dp = new int[3][2];
        dp[0][0] = cost[0][0];
        dp[1][0] = cost[0][1];
        dp[2][0] = cost[0][2];
        for (int i = 1; i < cost.length; i++) {
            dp[0][i % 2] = Math.min(dp[1][(i - 1) % 2], dp[2][(i - 1) % 2]) + cost[i][0];
            dp[1][i % 2] = Math.min(dp[0][(i - 1) % 2], dp[2][(i - 1) % 2]) + cost[i][1];
            dp[2][i % 2] = Math.min(dp[1][(i - 1) % 2], dp[0][(i - 1) % 2]) + cost[i][2];
        }
        return Math.min(Math.min(dp[0][(cost.length - 1) % 2], dp[1][(cost.length - 1) % 2]), dp[2][(cost.length - 1) % 2]);
    }
}
