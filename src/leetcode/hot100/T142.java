package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/29 13:50
 * @Description
 */
public class T142 {
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                fast = head;
                break;
            }
        }
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
