package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/9/20 10:15
 * @Description
 * 
 * f(i) = max(f(i - 1), f(i - 2) + 1)
 */
public class T2560 {
    
    public int minCapability(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        //二分
        while (left <= right){
            int mid = left + (right - left >> 1);
            if (check(nums, k, mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    //动态规划
    private boolean check(int[] nums, int k, int mx) {
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (num > mx){
                i = j;
            }else {
                int temp = j;
                j = Math.max(j, i + 1);
                i = temp;
            }
        }
        return j < k;
    }
    
}
