package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/8/16 11:29
 * @Description 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * 
 * s ="()(()"
 * 
 */
public class T32 {
    
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new T32().longestValidParentheses(s));
    }
    
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        if (s.length() == 0){
            return maxLength;
        }
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                //')'
                if (stack.isEmpty()){
                    start = i + 1;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        maxLength = Math.max(maxLength, i - start + 1);
                    }else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }
    
    public int longestValidParentheses1(String s) {
        int maxLength = 0;
        if (s.length() == 0){
            return maxLength;
        }
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //左括号直接入栈
            if ('(' == chars[i]){
                stack.push(i);
            }else {
                //右括号，如果出栈的元素是左括号，那么他们是符合条件的一对括号
                if (!stack.isEmpty() && chars[stack.peek()] == '('){
                    Integer left = stack.pop();
                    chars[left] = '0';
                    chars[i] = '0';
                }
            }
        }
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0'){
                length++;
            }else {
                maxLength = Math.max(maxLength, length);
                length = 0;
            }
        }
        return Math.max(maxLength, length);
    }
}
