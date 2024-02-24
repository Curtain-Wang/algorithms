package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/2 14:31
 * @Description f(i, j) = f(i - 1, j) + f(i, j)
 */
public class T98 {
    
    public static void main(String[] args) {
        System.out.println(uniquePaths1(2, 2));
    }
    
    public static int uniquePaths(int n, int m){
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
    
    public static int uniquePaths1(int n, int m){
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }
    
    public static int uniquePaths2(int n, int m){
        int[][] dp = new int[n][m];
        return helper(dp, n - 1, m - 1);
    }
    
    private static int helper(int[][] dp, int n, int m) {
        if (m == 0 || n == 0){
            dp[n][m] = 1;
        }else {
            dp[n][m] = helper(dp, n - 1, m) + helper(dp, n, m - 1);
        }
        return dp[n][m];
    }
}
