package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/20 15:16
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class T22 {
    int left;
    int right;
    int n;
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0);
        return ans;
    }
    
    private void dfs(int i) {
        if (i == 2 * n){
            ans.add(sb.toString());
        }else {
            if (left < n){
                left++;
                sb.append("(");
                dfs(i + 1);
                left--;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left){
                right++;
                sb.append(")");
                dfs(i + 1);
                right--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
