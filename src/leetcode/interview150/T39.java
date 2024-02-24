package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/19 10:42
 * @Description
 * 
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class T39 {
    
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        List<Integer> demo = new ArrayList<>();
        dfs(demo, target, 0);
        return result;
    }
    
    private void dfs(List<Integer> demo, int target, int start) {
        if (target == 0){
            result.add(new ArrayList<>(demo));
        }else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target){
                    break;
                }
                demo.add(candidates[i]);
                dfs(demo, target - candidates[i], i);
                demo.remove(demo.size() - 1);
            }
        }
    }
}
