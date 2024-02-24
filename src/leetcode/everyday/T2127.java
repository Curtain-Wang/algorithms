package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/11/1 10:14
 * @Description
 */
public class T2127 {
    
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 2};
    }
    
    
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<Integer>[] rg = new List[n]; //枝叶上的反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        int[] deg = new int[n];
        //计算每个节点的入度
        for (int i : favorite) {
            deg[i]++;
        }
        //收集枝叶
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0){
                q.add(i);
            }
        }
        //拓扑排序，一点一点剪去入度为0的枝叶
        while (!q.isEmpty()){
            Integer poll = q.poll();
            int i = favorite[poll];
            rg[i].add(poll);
            if (--deg[i] == 0){
                q.add(i);
            }
        }
        int maxRing = 0, chain = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0){
                continue;
            }
            deg[i] = 0;
            int size = 1;
            for (int x = favorite[i]; x != i; x = favorite[x]){
                deg[x] = 0; //将遍历到的节点入度设置为0，避免重复访问
                size++;
            }
            if (size == 2){
                chain += rdfs(rg, i) + rdfs(rg, favorite[i]);
            }else {
                maxRing = Math.max(maxRing, size);
            }
        }
        return Math.max(maxRing, chain);
    }
    
    private int rdfs(List<Integer>[] rg, int i) {
        int length = 1;
        for (Integer son : rg[i]) {
            length = Math.max(length, rdfs(rg, son) + 1);
        }
        return length;
    }
}
