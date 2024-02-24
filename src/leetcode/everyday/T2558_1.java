package leetcode.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Curtain
 * @Date 2023/10/28 10:49
 * @Description
 */
public class T2558_1 {
    
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            priorityQueue.offer(gift);
            ans += gift;
        }
        while (k-- > 0){
            Integer poll = priorityQueue.poll();
            ans -= (poll - Math.sqrt(poll));
            priorityQueue.offer((int) Math.sqrt(poll));
        }
        return ans;
    }
}
