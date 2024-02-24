package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/4 11:00
 * @Description
 */
public class T449 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(new T449().serialize(root));
        System.out.println(new T449().deserialize("2,1,3"));
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
    
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null){
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] nodes = data.split(",");
        return dfs1(nodes, 0, nodes.length - 1);
    }
    
    private TreeNode dfs1(String[] nodes, int l, int r) {
        if (l > r){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[l]));
        int rootVal = Integer.valueOf(nodes[l]);
        int rr = r;
        int ll = l + 1;
        while (ll < rr){
            int mid = ll + rr >> 1;
            if (Integer.valueOf(nodes[mid]) > Integer.valueOf(rootVal)){
                rr = mid;
            }else {
                ll = mid + 1;
            }
        }
        if (Integer.valueOf(nodes[rr]) <= rootVal){
            rr++;
        }
        root.left = dfs1(nodes, l + 1, rr - 1);
        root.right = dfs1(nodes, rr, r);
        return root;
    }
}
