package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/11/6 10:37
 * @Description
 */
public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode fast = sentry;
        ListNode slow = sentry;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sentry.next;
    }
    
}
