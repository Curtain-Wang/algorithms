package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/25 15:43
 * @Description
 */
public class T35 {
    
    public static void main(String[] args) {
        System.out.println(new T35().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
    
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                return mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
