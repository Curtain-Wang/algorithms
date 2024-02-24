package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/29 10:24
 * @Description
 */
public class T141 {
    
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
