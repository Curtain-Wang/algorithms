package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/14 11:01
 * @Description
 */
public class T35 {
    public int searchInsert(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
    
    private int bs(int[] nums, int left, int right, int target) {
        //二分到最后一个数了
        if (left == right){
            return nums[left] >= target ? left : left + 1;
        }else {
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                return bs(nums, left, mid - 1, target);
            }else {
                return bs(nums, mid + 1, right, target);
            }
        }
    }
}
