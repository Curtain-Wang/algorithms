package leetcode.interview150;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/10/25 15:32
 * @Description
 */
public class T42 {
    
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(new T42().trap(height));
    }
    
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                Integer bot = stack.pop();
                if (!stack.isEmpty()){
                    Integer left = stack.peek();
                    ans += (i - left - 1) * (Math.min(height[i], height[left]) - height[bot]);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
