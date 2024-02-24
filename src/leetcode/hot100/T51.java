package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/14 10:26
 * @Description
 */
public class T51 {
    
    List<List<String>> result = new ArrayList<>();
    int n = 0;
    List<Integer> demo = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        dfs(0);
        return result;
    }
    
    private void dfs(int i) {
        if (i == n){
            result.add(dealDemo(demo));
        }else {
            //n种选择
            for (int j = 0; j < n; j++) {
                //满足条件的皇后落点位
                if (verify(i, j)){
                    demo.add(j);
                    dfs(i + 1);
                    demo.remove(demo.size() - 1);
                }
            }
        }
    }
    
    private List<String> dealDemo(List<Integer> demo) {
        List<String> path = new ArrayList<>();
        for (Integer i : demo) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            path.add(new String(chars));
        }
        return path;
    }
    
    private boolean verify(int i, int j) {
        for (int i1 = 0; i1 < demo.size(); i1++) {
            int j1 = demo.get(i1);
            if (i == i1 || j == j1 || Math.abs(i - i1) == Math.abs(j - j1)){
                return false;
            }
        }
        return true;
    }
}
