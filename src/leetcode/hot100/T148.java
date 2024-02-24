package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/31 9:53
 * @Description
 */
public class T148 {
    
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
//        ListNode node5 = new ListNode(0);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
//        node3.next = node5;
        new T148().sortList(node4);
    }
    
    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode curNode = head.next;
        int maxValue = head.val;
        ListNode prevNode = head;
        while (curNode != null) {
            if (curNode.val >= maxValue) {
                maxValue = curNode.val;
                prevNode = curNode;
                curNode = curNode.next;
                continue;
            }
            prevNode.next = curNode.next;
            //遍历过去的节点
            ListNode prev = null;
            ListNode indexNode = newHead;
            while (indexNode != null) {
                if (curNode.val >= indexNode.val) {
                    prev = indexNode;
                    indexNode = indexNode.next;
                    continue;
                }
                //将当前节点插进去
                ListNode tmp = curNode.next;
                curNode.next = indexNode;
                if (prev != null) {
                    prev.next = curNode;
                } else {
                    newHead = curNode;
                }
                curNode = tmp;
                break;
            }
        }
        return newHead;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            //当前合并段的前一个节点，对合并后的当前段进行连接
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int j = 1; j < subLength && cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                //断开和合并段前半部分和后半部分的连接
                cur.next = null;
                cur = head2;
                for (int j = 1; j < subLength && cur != null; j++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummy.next;
    }
}
