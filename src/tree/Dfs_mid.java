package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/11/22 10:30
 * @Description
 */
public class Dfs_mid {
    private List<TreeNode> list = new ArrayList<>();
    private Stack<TreeNode> stack = new Stack<>();
    
    
    public void dfs(TreeNode cur){
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            list.add(cur);
            cur = cur.getRight();
        }
    }
}
