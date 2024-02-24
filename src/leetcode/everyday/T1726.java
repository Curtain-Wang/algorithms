package leetcode.everyday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/10/19 10:49
 * @Description 同积元组
 * 
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 *
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * nums 中的所有元素 互不相同
 */ 
public class T1726 {
    
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        System.out.println(new T1726().tupleSameProduct(nums));
    }
    
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int ans = 0;
        for (Integer count : map.values()) {
            if (count > 1){
                ans += count == 2 ? 8 : count * (count - 1) * 4;
            }
        }
        return ans;
    }
}


