package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/9 11:02
 * @Description
 */
public class T110 {
    
    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(new T110().allPathSourceTarget(graph));
    }
    
    private List<List<Integer>> allPathSourceTarget(int[][] graph){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, graph, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int[][] graph, int i) {
        path.add(i);
        if (i == graph.length - 1){
            List<Integer> path1 = new ArrayList<>(path);
            result.add(path1);
        }else {
            for (int node : graph[i]) {
                dfs(result, path, graph, node);
            }
        }
        path.remove(path.size() - 1);
    }
}
