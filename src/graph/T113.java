package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/9 16:51
 * @Description
 */
public class T113 {
    
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {1, 2}};
        System.out.println(new T113().findOrder(4, prerequisites));
    }
    
    private int[] findOrder(int numCourse, int[][] prerequisites){
        int[] inDegrees = new int[numCourse];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            result.add(remove);
            List<Integer> list = graph.get(remove);
            if (list != null){
                for (Integer course : list) {
                    inDegrees[course]--;
                    if (inDegrees[course] == 0){
                        queue.add(course);
                    }
                } 
            }
        }
        return result.size() == numCourse ? result.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
