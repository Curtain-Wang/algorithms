package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/1 16:37
 * @Description
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */
public class T210 {
    
    public static void main(String[] args) {
        int[][] a = {{1,0}};
        System.out.println(new T210().findOrder(2, a));
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> orDefault = map.getOrDefault(prerequisite[1], new ArrayList<>());
            orDefault.add(prerequisite[0]);
            map.put(prerequisite[1], orDefault);
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            result[index++] = poll;
            List<Integer> list = map.get(poll);
            if (list != null) {
                for (Integer integer : list) {
                    if (--degree[integer] == 0){
                        queue.add(integer);
                    }
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}
