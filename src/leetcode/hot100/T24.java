package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/29 16:28
 * @Description
 */
public class T24 {
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new T24().swapPairs(node1));
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode pre = sentry;
        while (pre.next != null && pre.next.next != null){
            ListNode start = pre.next;
            ListNode end = pre.next.next;
            ListNode tmp = end.next;
            pre.next = end;
            end.next = start;
            start.next = tmp;
            pre = start;
        }
        return sentry.next;
    }
}
