package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/8/24 16:55
 * @Description 统计参与通信的服务器
 * 
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 * 
 */
public class T1267 {
    
    public int countServers(int[][] grid) {
        int[] rowFlag = new int[grid.length];
        int[] colFlag = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    rowFlag[i]++;
                    colFlag[j]++;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rowFlag[i] > 1 || colFlag[j] > 1)){
                    result++;
                }
            }
        }
        return result;
    }
}
