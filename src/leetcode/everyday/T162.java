package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/12/18 9:21
 * @Description 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class T162 {
    
    public static void main(String[] args) {
        System.out.println(new T162().findPeakElement(new int[]{1, 2}));
    }
    
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + right >> 1;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
//    public int findPeakElement(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int index = left + (right - left) / 2;
//            if (index == 0) {
//                if (nums[index] > nums[index + 1]) {
//                    return index;
//                } else {
//                    left = index + 1;
//                }
//            } else if (index == nums.length - 1) {
//                if (nums[index] > nums[index - 1]) {
//                    return index;
//                } else {
//                    right = index - 1;
//                }
//            } else if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
//                return index;
//            } else if (nums[index] < nums[index + 1]) {
//                left = index + 1;
//            } else {
//                right = index - 1;
//            }
//        }
//        return -1;
//    }
}
