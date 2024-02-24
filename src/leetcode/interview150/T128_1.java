package leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/10/26 20:07
 * @Description
 */
public class T128_1 {
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 1;
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums) {
            if (unionFind.find(num + 1) != null){
                unionFind.union(num, num + 1);
            }
        }
        for (int num : nums) {
            Integer parent = unionFind.find(num);
            ans = Math.max(parent - num + 1, ans);
        }
        return ans;
    }
}
class UnionFind {
    //记录每个节点的父节点
    private Map<Integer, Integer> parent = new HashMap<>();
    
    public UnionFind(int nums[]){
        for (int num : nums) {
            parent.put(num, num);
        }
    }
    
    public Integer find(int num){
        if (!parent.containsKey(num)){
            return null;
        }
        while (num != parent.get(num)){
            parent.put(num, parent.get(parent.get(num)));
            num = parent.get(num);
        }
        return num;
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y){
            parent.put(x, y);
        }
    }
}
