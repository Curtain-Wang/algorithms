package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/29 14:00
 * @Description
 */
public class T2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode tmp = node;
        boolean isAddOne = false;
        while (l1 != null || l2 != null){
            if (l1 != null){
                tmp.next = l1;
                tmp = tmp.next;
                tmp.val += l2 == null ? 0 : l2.val;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                tmp = tmp.next;
            }
            if (isAddOne){
                tmp.val++;
            }
            if (tmp.val > 9){
                isAddOne = true;
                tmp.val %= 10;
            }else {
                isAddOne = false;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (isAddOne){
            ListNode lastNode = new ListNode();
            lastNode.val = 1;
            tmp.next = lastNode;
        }
        return node.next;
    }
}
