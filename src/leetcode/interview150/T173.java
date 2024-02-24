package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Curtain
 * @Date 2023/11/22 9:22
 * @Description
 */
public class T173 {
}

class BSTIterator {
    private Deque<Integer> deque = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    private void dfs(TreeNode cur) {
        if (cur != null) {
            dfs(cur.left);
            deque.offer(cur.val);
            dfs(cur.right);
        }
    }
    
    public int next() {
        return deque.pollFirst();
    }
    
    public boolean hasNext() {
        return deque.size() > 0;
    }
}
