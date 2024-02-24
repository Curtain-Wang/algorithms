package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author Curtain
 * @Date 2023/12/29 10:25
 * @Description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class T215 {
    
    public static void main(String[] args) {
        System.out.println(new T215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
    
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }
    
    private int quickSelect(List<Integer> list, int k) {
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int pivot = list.get(new Random().nextInt(list.size()));
        for (Integer num : list) {
            if (num > pivot){
                big.add(num);
            }else if (num < pivot){
                small.add(num);
            }else {
                equal.add(num);
            }
        }
        //说明第K大的数在big这个list里面
        if (big.size() > k - 1){
            return quickSelect(big, k);
        }else if (big.size() + equal.size() < k){
            return quickSelect(small, k - big.size() - equal.size());
        }else {
            return pivot;
        }
    }
}
