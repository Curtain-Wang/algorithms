package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/11/22 10:57
 * @Description
 */
public class T2304 {
    
    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(new T2304().minPathCost(grid, moveCost));
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] lastDp = new int[cols];
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) {
            lastDp[i] = grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < cols; k++) {
                    min = Math.min(lastDp[k] + moveCost[grid[i - 1][k]][j] + grid[i][j], min);
                }
                dp[j] = min;
            }
            int[] tmp = lastDp;
            lastDp = dp;
            dp = tmp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i : lastDp) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}
