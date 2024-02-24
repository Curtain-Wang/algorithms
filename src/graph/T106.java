package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/8/8 10:34
 * @Description
 */
public class T106 {
    
    public static void main(String[] args) {
        int[][] graph = {{1,3}, {0,2},{1,3},{0,2}};
        System.out.println(new T106().isBipartite(graph));
    }
    
    
    private boolean isBipartite(int[][] graph){
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0; i < size; i++) {
            if (colors[i] == -1){
                if (!canSetColor1(graph, colors, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean canSetColor(int[][] graph, int[] colors, int i, int color) {
        colors[i] = color;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            Integer now = queue.remove();
            int[] neighbors = graph[now];
            for (int neighbor : neighbors) {
                if (colors[neighbor] > -1){
                    if (colors[neighbor] == colors[now]){
                        return false;
                    }
                }else {
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[now];
                }
            }
        }
        return true;
    }
    
    private boolean canSetColor1(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] > - 1){
            return colors[i] == color;
        }
        colors[i] = color;
        int[] neighbors = graph[i];
        for (int neighbor : neighbors) {
            if (!canSetColor1(graph, colors, neighbor, 1 - color)){
                return false;
            }
        }
        return true;
    }
}
