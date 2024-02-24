package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/9/8 11:22
 * @Description
 */
public class T84 {
    
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        //单调栈，遍历入栈、如果栈顶元素大于当前元素，则计算以栈顶元素为高的最大面积，并弹出
        for (int i = 0; i < heights.length; i++) {
            //单调栈中最外面元素大于即将入栈的元素
            //计算以单调栈中最外面元素为高的最大面积
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int height= heights[stack.pop()];
                int right = i - 1;
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (right - left) * height);
            }
            stack.push(i);
        }
        //对栈里面的元素进行面积计算
        if (!stack.isEmpty()){
            int right = stack.peek();
            while (!stack.isEmpty()){
                int height= heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (right - left) * height);
            }
        }
        return maxArea;
    }
}
