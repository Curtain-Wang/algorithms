package leetcode.hot100;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/9/8 15:07
 * @Description
 */
public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(root.val);
        while (!queue.isEmpty()){
            Deque<TreeNode> sonQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    sonQueue.offer(poll.left);
                }
                if (poll.right != null){
                    sonQueue.offer(poll.right);
                }
            }
            if (!sonQueue.isEmpty()){
                result.add(sonQueue.getLast().val);
            }
            queue = sonQueue;
        }
        return result;
    }
}
