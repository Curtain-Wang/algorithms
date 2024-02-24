package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/8/4 11:22
 * @Description
 */
public class T105 {
    
    public static void main(String[] args) {
        int[][] a = {{1,1,0,0,1},{1,0,0,1,0},{1,1,0,1,0},{0,0,1,0,0}};
        System.out.println(new T105().maxAreaIsland(a));
    }
    
    private int maxAreaIsland(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, getArea2(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        int[] now = {i, j};
        queue.add(now);
        int area = 0;
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while (!queue.isEmpty()){
            int[] pos = queue.remove();
            area++;
            for (int k = 0; k < dirs.length; k++) {
                int[] dir = dirs[k];
                int c = dir[0] + pos[0];
                int r = dir[1] + pos[1];
                if (c >= 0 && c < grid.length && r >= 0 && r < grid[0].length && !visited[c][r] && grid[c][r] == 1){
                    int[] a = {c, r};
                    queue.add(a);
                    visited[c][r] = true;
                }
            }
        }
        return area;
    }
    
    private int getArea1(int[][] grid, boolean[][] visited, int i, int j){
        Stack<int[]> stack = new Stack<>();
        visited[i][j] = true;
        int area = 0;
        stack.push(new int[]{i, j});
        int[][] dirs = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        while (!stack.isEmpty()){
            int[] pos = stack.pop();
            area++;
            for (int[] dir : dirs) {
                int c = dir[0] + pos[0];
                int r = dir[1] + pos[1];
                if (c >= 0 && c < grid.length && r >= 0 && r < grid[0].length && grid[c][r] == 1 && !visited[c][r]){
                    stack.push(new int[]{c,r});
                    visited[c][r] = true;
                }
            }
        }
        return area;
    }
    
    private int getArea2(int[][] grid, boolean[][] visited, int i, int j){
        int area = 1;
        visited[i][j] = true;
        int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int c = i + dir[0];
            int r = j + dir[1];
            if (c >= 0 && c < grid.length && r >= 0 && r < grid[0].length && grid[c][r] == 1 && !visited[c][r]){
                visited[c][r] = true;
                area += getArea2(grid, visited, c, r);
            }
        }
        return area;
    }
}
