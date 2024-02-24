package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Curtain
 * @Date 2023/11/22 10:36
 * @Description
 */
public class T173_1 {
    
    class BSTIterator {
        private Deque<TreeNode> deque = new ArrayDeque<>();
        public BSTIterator(TreeNode root) {
            addNode(root);
        }
        
        private void addNode(TreeNode root) {
            while (root != null){
                deque.addLast(root);
                root = root.left;
            }
        }
        
        public int next() {
            TreeNode treeNode = deque.pollLast();
            int ans = treeNode.val;
            addNode(treeNode.right);
            return ans;
        }
        
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
