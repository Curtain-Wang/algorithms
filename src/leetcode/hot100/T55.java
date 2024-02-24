package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/6 10:50
 * @Description
 */
public class T55 {
    
    public boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < i){
                return false;
            }
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }
}
