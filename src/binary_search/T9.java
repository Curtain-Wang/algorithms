package binary_search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Curtain
 * @Date 2023/7/4 20:41
 * @Description
 */
public class T9 {
    
    
    public ListNode mergeList(ListNode[] lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (ListNode list : lists) {
            priorityQueue.offer(list);
        }
        ListNode dst = new ListNode();
        ListNode cur = dst;
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            cur.next = poll;
            if (poll.next != null){
                priorityQueue.offer(poll.next);
            }
        }
        return dst.next;
    }
}
