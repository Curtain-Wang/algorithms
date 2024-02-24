package binary_search;

import com.sun.jmx.snmp.SnmpUnknownModelException;

/**
 * @Author Curtain
 * @Date 2023/6/29 16:22
 * @Description
 */
public class T1 {
    
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] >= target){
                if (mid == 0 || nums[mid - 1] < target){
                    return mid;
                }
            }
        }
        return nums.length;
    }
    
    public int peekIndexInMountainArray(int[] nums){
        int left = 1;
        int right = nums.length - 2;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
