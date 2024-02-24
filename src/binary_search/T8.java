package binary_search;

/**
 * @Author Curtain
 * @Date 2023/7/4 20:04
 * @Description
 */
public class T8 {
    
    private ListNode sort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode head1 = split(head);
        head = sort(head);
        head1 = sort(head1);
        head = merge(head, head1);
        return head;
    }
    
    private ListNode merge(ListNode head, ListNode head1) {
        ListNode dst = new ListNode();
        ListNode cur = dst;
        while (head != null && head1 != null){
            if (head.val < head1.val){
                cur.next = head;
                head = head.next;
            }else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head == null ? head1 : head;
        return dst.next;
    }
    
    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midStart = slow.next;
        slow.next = null;
        return midStart;
    }
}
