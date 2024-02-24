package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/28 17:22
 * @Description
 */
public class T206 {
    
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    
}
