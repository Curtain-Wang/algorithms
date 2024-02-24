package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/22 9:38
 * @Description
 */
public class T238 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new T238().productExceptSelf(nums));
    }
    
    public int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
    
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[nums.length - 1 - i] = suffix[nums.length - i] * nums[nums.length - 1 - i];
        }
        nums[0] = suffix[1];
        nums[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }
        return nums;
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        //前缀
        for (int i = 0, j = 1; i < nums.length; i++) {
            ans[i] = j;
            j *= nums[i];
        }
        //后缀
        for (int i = nums.length - 1, j = 1; i >= 0; i--) {
            ans[i] *= j;
            j *= nums[i];
        }
        return ans;
    }
}
