package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/5 13:55
 * @Description
 */
public class T34 {
    
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        bs(nums, 0, nums.length - 1, range, target);
        
        return range;
    }
    
    private void bs(int[] nums, int start, int end, int[] range, int target) {
        if (start > end || end >= nums.length) {
            return;
        }
        int mid = start + end >> 1;
        if (nums[mid] > target){
            bs(nums, start, mid - 1, range, target);
        }else if (nums[mid] < target){
            bs(nums, mid + 1, end, range, target);
        }else {
            if (range[0] == -1 || mid < range[0]){
                range[0] = mid;
            }
            if (mid > range[1]){
                range[1] = mid;
            }
            bs(nums, start, mid - 1, range, target);
            bs(nums, mid + 1, end, range, target);
        }
    }
}
