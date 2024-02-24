package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/9/12 15:11
 * @Description
 */
public class T1462 {
    
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (g[prerequisite[0]] == null){
                g[prerequisite[0]] = new ArrayList();
            }
            g[prerequisite[0]].add(prerequisite[1]);
            isPre[prerequisite[0]][prerequisite[1]] = true;
            indegree[prerequisite[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            int cur = deque.poll();
            if (g[cur] != null){
                for (Integer ne : g[cur]) {
                    for (int i = 0; i < numCourses; i++) {
                        isPre[i][ne] = isPre[i][ne] || isPre[i][cur];
                    }
                    indegree[ne]--;
                    if (indegree[ne] == 0){
                        deque.offer(ne);
                    }
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPre[query[0]][query[1]]);
        }
        return result;
    }
}
