package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/9/13 9:24
 * @Description
 */
public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //pres[i]表示前提为i的课程号列表
        List<Integer>[] pres = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (pres[prerequisite[1]] == null){
                pres[prerequisite[1]] = new ArrayList();
            }
            pres[prerequisite[1]].add(prerequisite[0]);
        }
        int[] indegree = new int[numCourses];
        int remainCourses = numCourses;
        
        //计算每个课程的入度
        for (int i = 0; i < numCourses; i++) {
            if (pres[i] != null){
                for (Integer pre : pres[i]) {
                    indegree[pre]++;
                }
            }
        }
        //将入度为0的课程放入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        //修入度为0的课程
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            remainCourses--;
            //修完后，给依赖该课程的课程入度-
            if (pres[course] != null){
                for (Integer integer : pres[course]) {
                    indegree[integer]--;
                    if (indegree[integer] == 0){
                        queue.offer(integer);
                    }
                }    
            }
        }
        return remainCourses == 0;
    }
}
