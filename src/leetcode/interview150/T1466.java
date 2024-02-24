package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/7 9:30
 * @Description
 */
public class T1466 {
    
    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int[] connection : connections) {
            List<Integer> list1 = map1.getOrDefault(connection[0], new ArrayList<>());
            list1.add(connection[1]);
            map1.put(connection[0], list1);
            List<Integer> list2 = map2.getOrDefault(connection[1], new ArrayList<>());
            list2.add(connection[0]);
            map2.put(connection[1], list2);
        }
        boolean[] visited = new boolean[n];
        queue.add(0);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            visited[poll] = true;
            //x -> poll, 不用修改修路方向就能到达
            List<Integer> list2 = map2.get(poll);
            if (list2 != null && list2.size() > 0){
                for (Integer integer : list2) {
                    if (!visited[integer]){
                        queue.add(integer);
                    }
                }
            }
            //poll -> x, 修改方向
            List<Integer> list3 = map1.get(poll);
            if (list3 != null){
                for (Integer integer : list3) {
                    if (!visited[integer]){
                        ans++;
                        queue.add(integer);
                    }
                }
            }
    
        }
        return ans;
    }
}
