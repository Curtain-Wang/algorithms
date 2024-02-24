package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/5 14:36
 * @Description 到达首都的最少油耗
 */
public class T2477 {
    
    public static void main(String[] args) {
        int[][] roads = {{0,1},{0,2},{0,3}};
        System.out.println(new T2477().minimumFuelCost(roads, 5));
    }
    
    private long ans;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] g = new List[roads.length + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] road : roads) {
            int x = road[0], y = road[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1, g, seats);
        return ans;
    }
    
    private long dfs(int i, int fahter, List<Integer>[] g, int seats) {
        List<Integer> list = g[i];
        long size = 1;
        for (Integer node : list) {
            if (node != fahter){
                size += dfs(node, i, g, seats);
            }
        }
        if (i > 0){
            ans += (size - 1) / seats + 1;
        }
        return size;
    }
}
