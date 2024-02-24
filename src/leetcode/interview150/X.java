package leetcode.interview150;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/10/23 9:27
 * @Description
 */
public class X {
    
    public static void main(String[] args) {
        String[] a = {"4","13","5","/","+"};
        System.out.println(new X().evalRPN(a));
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int ans = calc(num2, num1, token);
                stack.push(ans);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    
    private int calc(int num1, int num2, String token) {
        switch (token){
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 /num2;
        }
        return 0;
    }
    
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
}
