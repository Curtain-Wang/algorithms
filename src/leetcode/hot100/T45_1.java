package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/21 10:17
 * @Description
 */
public class T45_1 {
    
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
