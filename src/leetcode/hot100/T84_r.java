package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/9/19 16:20
 * @Description
 * 
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class T84_r {
    
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new T84_r().largestRectangleArea(heights));
    }
    
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                //计算以栈顶为高的最大面积
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int height = heights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - left - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
            }
            stack.push(i);
        }
        if (!stack.isEmpty()){
            int right = stack.peek() + 1;
            while (!stack.isEmpty()){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        return maxArea;
    }
}
