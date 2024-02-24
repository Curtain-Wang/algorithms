package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/11/15 10:04
 * @Description
 */
public class T117_2 {
    public Node connect(Node root){
        Node dummy = new Node();
        Node cur = root;
        while (cur != null){
            dummy.next = null;
            Node nextLevelNode = dummy;
            while (cur != null){
                if (cur.left != null){
                    nextLevelNode.next = cur.left;
                    nextLevelNode = cur.left;
                }
                if (cur.right != null) {
                    nextLevelNode.next = cur.right;
                    nextLevelNode = cur.right;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
    
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
