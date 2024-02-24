package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/10/31 14:20
 * @Description
 */
public class T2003 {
    
    /**
     * [1,2,3,2,1]
     * [6,2,3,2,1]
     * @param args
     */
    public static void main(String[] args) {
        int[] parents = {-1,0,0,2};
        int[] nums = {1,2,3,4};
        System.out.println(new T2003().smallestMissingValueSubtree(parents, nums));
    }
    
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        //寻找基因为1的节点
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                node = i;
            }
        }
        //没有基因为1的节点，那么所有节点的缺失基因为1
        if (node == -1){
            return ans;
        }
        //构建节点i的子节点列表
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parents[i]].add(i);
        }
        int mes = 2;
        //包含的基因
        Set<Integer> vis = new HashSet<>();
        //从基因为1的节点往上走，走不到的节点，都是缺失1的，也就不用遍历
        while (node >= 0){
            //遍历以node为根的数，获取它所包含的基因
            dfs(node, g, vis, nums);
            while (vis.contains(mes)){
                mes++;
            }
            ans[node] = mes;
            node = parents[node];
        }
        return ans;
    }
    
    private void dfs(int node, List<Integer>[] g, Set<Integer> vis, int[] nums) {
        vis.add(nums[node]);
        for (Integer sonNode : g[node]) {
            if (!vis.contains(nums[sonNode])){
                dfs(sonNode, g, vis, nums);
            }
        }
    }
}
