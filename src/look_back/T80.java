package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/17 17:04
 * @Description
 */
public class T80 {
    
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(3, 2);
        System.out.println(combine);
    }
    
    private static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || n < k){
            return null;
        }
        List<Integer> subsets = new ArrayList<>();
        helper(n, k, 1, subsets, result);
        return result;
    }
    
    private static void helper(int n, int k, int i, List<Integer> subsets, List<List<Integer>> result) {
        if (subsets.size() == k){
            result.add(new ArrayList<>(subsets));
        }else if (i <= n){
            helper(n, k, i + 1, subsets, result);
            subsets.add(i);
            helper(n, k, i + 1, subsets, result);
            subsets.remove(subsets.size() - 1);
        }
    }
}
