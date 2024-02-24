package leetcode.interview150;

import javafx.util.Pair;
import leetcode.hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/23 11:15
 * @Description
 */
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    level.add(poll.val);
                    if (poll.left != null) {
                        deque.addLast(poll.left);
                    }
                    if (poll.right != null) {
                        deque.addLast(poll.right);
                    }
                }
                result.add(level);
            }
        }
        return result;
    }
}
