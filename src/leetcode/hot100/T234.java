package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/29 9:57
 * @Description
 */
public class T234 {
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode tmp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
            
        }
        if (fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if (slow.val != pre.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
