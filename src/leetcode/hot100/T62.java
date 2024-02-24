package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/9/6 10:58
 * @Description
 */
public class T62 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
