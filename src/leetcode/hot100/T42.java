package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/8/13 11:21
 * @Description
 */
public class T42 {
    
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        new T42().trap(height);
    }
    
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                //将低洼弹出
                Integer bottom = stack.pop();
                //获取低洼左侧的墙
                if (stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                water += (i - left - 1) * (Math.min(height[i], height[left]) - height[bottom]);
            }
            stack.push(i);
        }
        return water;
    }
}
