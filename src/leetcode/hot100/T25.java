package leetcode.hot100;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/30 7:56
 * @Description
 */
public class T25 {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        //初始化每段的开头的上一个位置
        ListNode prev = dummy;
        //初始化每段结尾位置
        ListNode end = dummy;
        while (end != null){
            //定位该段反转结尾
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            //如果不是完整一段则结束
            if (end == null){
                break;
            }
            //定义该段开始位置
            ListNode start = prev.next;
            //保存下一段开始位置
            ListNode next = end.next;
            //将反转链表断开
            end.next = null;
            prev.next = reserve(start);
            //将反转后的列表接上后面的链表
            start.next = next;
            //更新prev
            prev = start;
            end = start;
        }
        return dummy.next;
    }
    
    private ListNode reserve(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
