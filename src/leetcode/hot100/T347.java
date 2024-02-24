package leetcode.hot100;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/9/21 9:32
 * @Description
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class T347 {
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((m1, m2) -> m1.getValue() - m2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k && entry.getValue() > queue.peek().getValue()){
                queue.poll();
                queue.offer(entry);
            }else if (queue.size() < k){
                queue.offer(entry);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
