package leetcode.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/9/13 7:51
 * @Description
 */
public class T994 {
    
    public int orangesRotting(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> twoQueue = new LinkedList<>();
        int oneCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                } else if (grid[i][j] == 2) {
                    twoQueue.offer(new int[]{i, j});
                }
            }
        }
        while (oneCount > 0 && !twoQueue.isEmpty()) {
            result++;
            Queue<int[]> nextTowQueue = new LinkedList<>();
            while (!twoQueue.isEmpty()){
                int[] twoIndex = twoQueue.poll();
                for (int[] direction : directions) {
                    int nexti = twoIndex[0] + direction[0];
                    int nextj = twoIndex[1] + direction[1];
                    if (isInArea(nexti, nextj, grid)) {
                        //腐烂新鲜橘子
                        if (grid[nexti][nextj] == 1) {
                            oneCount--;
                            grid[nexti][nextj] = 2;
                            nextTowQueue.add(new int[]{nexti, nextj});
                        }
                    }
                }
            }
            twoQueue = nextTowQueue;
        }
        return oneCount > 0 ? -1 : result;
    }
    
    private boolean isInArea(int nexti, int nextj, int[][] grid) {
        return nexti >= 0 && nexti < grid.length && nextj >= 0 && nextj < grid[0].length;
    }
}
