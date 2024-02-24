package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/31 15:19
 * @Description
 */
public class T23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1){
            int idx = 0;
            for (int i = 0; i < length; i += 2) {
                if (i == length -1){
                    lists[idx++] = lists[i];
                }else {
                    lists[idx++] = merge(lists[i], lists[i + 1]);
                }
            }
            length = idx;
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (node1 != null && node2 != null){
            if (node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 == null? node2 : node1;
        return dummy.next;
    }
}
