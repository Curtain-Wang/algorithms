package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/11/14 16:33
 * @Description
 */
public class T1334_2 {
    
    //f[i][j]=min(f[i][j],f[i][k]+f[k][j])
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] w = new int[n][n];
        for (int[] row : w) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], wt = edge[2];
            w[x][y] = w[y][x] = wt;
        }
        int[][] f = w;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                }
            }
        }
        int ans = 0;
        int minCnt = n - 1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && f[i][j] <= distanceThreshold){
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
}
