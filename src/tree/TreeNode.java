package tree;

/**
 * @Author Curtain
 * @Date 2023/6/15 10:16
 * @Description
 */
public class TreeNode {
    private Integer val;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode(Integer val) {
        this.val = val;
    }
    
    public Integer getVal() {
        return val;
    }
    
    public void setVal(Integer val) {
        this.val = val;
    }
    
    public TreeNode getLeft() {
        return left;
    }
    
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    
    public TreeNode getRight() {
        return right;
    }
    
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
