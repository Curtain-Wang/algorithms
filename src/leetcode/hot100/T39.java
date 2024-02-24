package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/5 14:08
 * @Description
 */
public class T39 {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] sum = {0};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> demo = new ArrayList<>();
        handle(demo, candidates, target, sum, result, 0);
        return result;
    }
    
    private void handle(List<Integer> demo, int[] candidates, int target, int[] sum, List<List<Integer>> result, int startIndex) {
        if (sum[0] > target) {
            return;
        }
        if (sum[0] == target) {
            result.add(new ArrayList<>(demo));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum[0] += candidates[i];
            demo.add(candidates[i]);
            handle(demo, candidates, target, sum, result, i);
            sum[0] -= candidates[i];
            demo.remove(demo.size() - 1);
        }
    }
}
