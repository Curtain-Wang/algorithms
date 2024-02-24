package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/11/1 14:34
 * @Description
 */
public class T138_1 {
    
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分链表
        Node pre = head;
        cur = head.next;
        Node res = head.next;
        while (cur.next != null){
            pre.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;
    }
}
