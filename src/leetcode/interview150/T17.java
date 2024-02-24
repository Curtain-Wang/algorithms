package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/14 15:42
 * @Description
 */
public class T17 {
    
    char[][] numChar = new char[][]{
            {}, 
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            StringBuilder sb = new StringBuilder();
            dfs(digits, sb, 0);
        }
        return ans;
    }
    private void dfs(String digits, StringBuilder sb, int i) {
        if (i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        for (char c : numChar[digits.charAt(i) - '1']) {
            sb.append(c);
            dfs(digits, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
