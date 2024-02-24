package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/10 20:02
 * @Description
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */
public class T11 {
    
    public static void main(String[] args) {
        
    }
    
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]){
                j--;
            }else {
                i++;
            }
        }
        return maxArea;
    }
}
