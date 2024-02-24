package leetcode.interview150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/12/18 15:05
 * @Description
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class T77 {
    
    private int n;
    private int k;
    private Set<Integer> visited = new HashSet<>();
    private List<Integer> demo = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return result;
    }
    
    private void dfs(int begin) {
        if (demo.size() == k){
            result.add(new ArrayList<>(demo));
        }else {
            for (int i = begin; i <= n + 1 - k + demo.size(); i++) {
                if (demo.size() == 0 || (!visited.contains(i))){
                    demo.add(i);
                    visited.add(i);
                    dfs(i + 1);
                    demo.remove(demo.size() - 1);
                    visited.remove(i);
                }
            }
        }
    }
}
