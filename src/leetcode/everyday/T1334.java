package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/11/14 10:40
 * @Description
 */
public class T1334 {
    
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(new T1334().findTheCity(4, edges, 4));
    }
     //超时
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //收集每个点的边
        List<int[]>[] borders = new List[n];
        fillBorders(borders, edges, distanceThreshold);
        int[] count = new int[n];
        int ans = 0;
        for (int i = 0; i < borders.length; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            Set<Integer> set = new HashSet<>();
            getCount(borders, i, distanceThreshold, visited, set);
            count[i] = set.size();
            if (count[i] <= count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
    
    private void fillBorders(List<int[]>[] borders, int[][] edges, int distanceThreshold) {
        for (int[] edge : edges) {
            if (borders[edge[0]] == null) {
                borders[edge[0]] = new ArrayList<>();
            }
            if (borders[edge[1]] == null) {
                borders[edge[1]] = new ArrayList<>();
            }
            //直线距离大于阈值的直接pass
            if (edge[2] > distanceThreshold) {
                continue;
            }
            borders[edge[0]].add(edge);
            borders[edge[1]].add(swap(edge, 0, 1));
        }
    }
    
    private int[] swap(int[] edge, int i, int j) {
        int[] ints = Arrays.copyOf(edge, edge.length);
        ints[0] = edge[1];
        ints[1] = edge[0];
        return ints;
    }
    
    private void getCount(List<int[]>[] borders, int borderIndex, int distanceThreshold, Set<Integer> visited, Set<Integer> destSet) {
        if (borders[borderIndex] != null) {
            for (int[] border : borders[borderIndex]) {
                if (!visited.contains(border[1]) && border[2] <= distanceThreshold) {
                    visited.add(border[1]);
                    destSet.add(border[1]);
                    getCount(borders, border[1], distanceThreshold - border[2], visited, destSet);
                    visited.remove(border[1]);
                }
            }
        }
    }
    
}
