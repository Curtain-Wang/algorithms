package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/8/7 15:18
 * @Description
 */
public class T107 {
    
    public static void main(String[] args) {
        int[][] graph = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = new T107().updateMatrix(graph);
        for (int[] anInt : ints) {
            System.out.println("===");
            for (int i : anInt) {
                System.out.println(i);
            }
        }
    }
    
    private int[][] updateMatrix(int[][] graph){
        int clength = graph.length;
        int rlength = graph[0].length;
        int[][] dists = new int[clength][rlength];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < clength; i++) {
            for (int j = 0; j < rlength; j++) {
                if (graph[i][j] == 0){
                    queue.add(new int[]{i, j});
                }else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()){
            int[] pos = queue.remove();
            for (int[] dir : dirs) {
                int c = pos[0] + dir[0];
                int r = pos[1] + dir[1];
                if (c >= 0 && c < clength && r >= 0 && r < rlength && dists[c][r] > dists[pos[0]][pos[1]] + 1){
                    queue.add(new int[]{c, r});
                    dists[c][r] = dists[pos[0]][pos[1]] + 1;
                }
            }
        }
        return dists;
    }
}
