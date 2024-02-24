package leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Curtain
 * @Date 2023/8/17 15:00
 * @Description
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class T239 {
    
    public static void main(String[] args) {
        int[] nums = {1, -1};
        System.out.println(new T239().maxSlidingWindow(nums, 1));
    }
    
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.getFirst()];
        for (int i = k; i < nums.length; i++) {
            queue.remove(i - k);
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            res[i - k + 1] = nums[queue.getFirst()];
        }
        return res;
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1){
                if (i > k - 1){
                    queue.remove(i - k);
                }
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
    
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
