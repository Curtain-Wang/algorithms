package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/8/15 15:09
 * @Description 22. 括号生成
 * 
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 提示：
 *
 * 1 <= n <= 8
 */ 
public class T22 {
    
    public static void main(String[] args) {
        System.out.println(new T22().generateParenthesis(2));
    }
    
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        handle(left, right, sb, result);
        return result;
    }
    
    private void handle(int left, int right,StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0){
            result.add(sb.toString());
        }else {
            if (left > 0){
                sb.append('(');
                handle(left - 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right > 0 && right > left){
                sb.append(')');
                handle(left, right - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
