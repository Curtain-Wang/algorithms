package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/8/13 10:48
 * @Description
 */
public class T283 {
    
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new T283().moveZeroes(nums);
    }
    
    public void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int moveStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                moveStep++;
            }else {
                nums[i - moveStep] = nums[i];
            }
        }
        for (int i = nums.length - moveStep; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
