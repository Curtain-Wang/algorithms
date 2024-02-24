package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/11/14 15:24
 * @Description
 */
public class T1334_1 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] w = new int[n][n];
        for (int[] row : w) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], wt = edge[2];
            w[x][y] = w[y][x] = wt;
        }
        int ans = 0;
        int minCnt = n - 1;
        int[][][] memo = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dfs(n - 1, i, j, w, memo) <= distanceThreshold){
                    cnt++;
                }
            }
            if (cnt <= minCnt){
                ans = i;
                minCnt = cnt;
            }
        }
        return ans;
    }
    
    private int dfs(int k, int i, int j, int[][] w, int[][][] memo) {
        if (k < 0){
            return w[i][j];
        }
        if (memo[k][i][j] != 0){
            return memo[k][i][j];
        }
        return memo[k][i][j] = Math.min(dfs(k - 1, i, j, w, memo), dfs(k - 1, i, k, w, memo) + dfs(k - 1, k, j, w, memo));
    }
    
}
