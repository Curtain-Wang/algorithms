package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/9/18 14:04
 * @Description
 */
public class T394 {
    
    public static void main(String[] args) {
        System.out.println(new T394().decodeString("3[a]2[bc]"));
    }
    
    public String decodeString(String s) {
        int k = 0;
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuilder> postResStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '['){
                multiStack.push(k);
                postResStack.push(res);
                res = new StringBuilder();
                k = 0;
            }else if (c == ']'){
                Integer multi = multiStack.pop();
                StringBuilder postStr = postResStack.pop();
                for (Integer j = 0; j < multi; j++) {
                    postStr.append(res);
                }
                res = postStr;
            }else if (c >= '0' && c <= '9'){
                k = k * 10 + (c - '0');
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
