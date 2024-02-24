package leetcode.everyday;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2024/1/10 15:56
 * @Description
 */
public class T2696 {
    
    public static void main(String[] args) {
        System.out.println(new T2696().minLength("ACBBD"));
    }
    
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
