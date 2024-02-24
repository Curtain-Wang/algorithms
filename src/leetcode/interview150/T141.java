package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/10/22 13:51
 * @Description
 */
public class T141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
