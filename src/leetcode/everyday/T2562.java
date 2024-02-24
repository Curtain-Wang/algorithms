package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/12 9:44
 * @Description 找出数组的串联值
 */
public class T2562 {
    
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long ans = 0;
        while (left < right){
            int w = 10;
            int rightVal = nums[right];
            while ((rightVal /= 10) > 0){
                w *= 10;
            }
            ans += nums[left] * w + nums[right];
            left++;
            right--;
        }
        if (left == right){
            ans += nums[left];
        }
        return ans;
    }
}
