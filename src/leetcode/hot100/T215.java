package leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/9/20 10:36
 * @Description
 */
public class T215 {
    
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k){
                queue.offer(nums[i]);
            }else {
                if (queue.peek() < nums[i]){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.poll();
    }
}
