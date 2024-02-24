package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/21 8:56
 * @Description
 */
public class T136 {
    
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
