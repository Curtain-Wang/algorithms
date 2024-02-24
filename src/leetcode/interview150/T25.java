package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/11/1 16:00
 * @Description
 */
public class T25 {
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new T25().reverseKGroup(node, 3));
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode cur = sentry.next;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
            if (count % k == 0){
                sentry.next = reverseBetween(sentry.next, count - k + 1, count);
            }
        }
        return sentry.next;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPre = null;
        ListNode leftNode = null;
        ListNode rightAfter = null;
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode pre = sentry;
        while (right > 0){
            if (left == 1){
                leftNode = pre.next;
                leftPre = pre;
            }
            if (right == 1){
                rightAfter = pre.next.next;
                pre.next.next = null;
            }
            pre = pre.next;
            left--;
            right--;
        }
        leftPre.next = reserve(leftNode);
        leftNode.next = rightAfter;
        return sentry.next;
    }
    
    private ListNode reserve(ListNode leftNode) {
        ListNode cur = leftNode;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
