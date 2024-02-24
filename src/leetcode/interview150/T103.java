package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/11/23 13:46
 * @Description
 */
public class T103 {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            boolean needReserve = false;
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    level.add(poll.val);
                    if (poll.left != null){
                        deque.add(poll.left);
                    }
                    if (poll.right != null){
                        deque.add(poll.right);
                    }
                }
                if (needReserve){
                    Collections.reverse(level);
                }
                needReserve = !needReserve;
                result.add(level);
            }
        }
        return result;
    }
    
}
