package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/22 11:06
 * @Description 缺失的第一个正数
 */
public class T41 {
    
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                check(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void check(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
