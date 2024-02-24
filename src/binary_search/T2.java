package binary_search;

/**
 * @Author Curtain
 * @Date 2023/6/29 18:47
 * @Description
 */
public class T2 {
    
    private int singleNonDuplicate(int[] nums){
        int left = 0;
        int right = nums.length / 2;
        while (left <= right){
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i + 1 == nums.length){
                break;
            }
            if (nums[i] != nums[i + 1]){
                if (mid == 0 || nums[i - 2] == nums[i - 1]){
                    return nums[i];
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
