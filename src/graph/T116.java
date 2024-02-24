package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/8/10 10:18
 * @Description
 */
public class T116 {
    
    public static void main(String[] args) {
        int[][] sr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new T116().findCycleNum(sr));
    }
    
    private int findCycleNum(int[][] sr){
        boolean[] visited = new boolean[sr.length];
        int result = 0;
        for (int i = 0; i < sr.length; i++) {
            if (!visited[i]){
                result++;
                findCycle1(sr, visited, i);
            }
        }
        return result;
    }
    
    private void findCycle(int[][] sr, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            visited[remove] = true;
            for (int friend = 0; friend < sr.length; friend++) {
                if (sr[remove][friend] == 1 && !visited[friend]){
                    queue.add(friend);
                }
            }
        }
    }
    
    private void findCycle1(int[][] sr, boolean[] visited, int i){
        if (visited[i]){
            return;
        }
        visited[i] = true;
        for (int j = 0; j < sr.length; j++) {
            if (sr[i][j] == 1 && !visited[j]){
                findCycle1(sr, visited, j);
            }
        }
    }
}
