package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/6/15 19:10
 * @Description 广度优先搜索（Breadth First Search）
 */
public class Bfs {
    
    public List bfs(TreeNode root){
        List result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            result.add(treeNode.getVal());
            if (treeNode.getLeft() != null){
                queue.offer(treeNode.getLeft());
            }
            if (treeNode.getRight() != null){
                queue.offer(treeNode.getRight());
            }
        }
        return result;
    }
}
