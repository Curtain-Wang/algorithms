package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/20 11:00
 * @Description
 */
public class T52 {
    
    List<Integer> demo = new ArrayList<>();
    int ans = 0;
    int n;
    
    public static void main(String[] args) {
        System.out.println(new T52().totalNQueens(6));
    }
    
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0);
        return ans;
    }
    
    //放置第row行的皇后
    private void dfs(int row) {
        if (row < n){
            for (int i = 0; i < n; i++) {
                if (verify(row, i)){
                    demo.add(i);
                    dfs(row + 1);
                    demo.remove(demo.size() - 1);
                }
            }
        }else {
            ans++;
        }
    }
    
    private boolean verify(int row, int col) {
        for (int i = 0; i < demo.size(); i++) {
            if (demo.get(i) == col || Math.abs(row - i) == Math.abs(col - demo.get(i))){
                return false;
            }
        }
        return true;
    }
}
