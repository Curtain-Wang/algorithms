package tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/6/16 14:52
 * @Description
 */
public class Practice {
    
    
    private int sum(TreeNode root){
        return dfsSum(root, 0);
    }
    
    private int dfsSum(TreeNode root, int lasTNodeSum) {
        if (root == null){
            return 0;
        }
        int sum = lasTNodeSum * 10 + root.getVal();
        return dfsSum(root.getLeft(), sum) + dfsSum(root.getRight(), sum);
    }
    
    
    private int pathSum(TreeNode root, int sum){
        Map<Integer, Integer> map = new HashMap<>();
        return dfsCount(root, sum, map, 0);
    }
    
    private int dfsCount(TreeNode treeNode, int sum, Map<Integer, Integer> map, Integer pathSum) {
        if (treeNode == null){
            return 0;
        }
        pathSum += treeNode.getVal();
        Integer count = map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        count += dfsCount(treeNode.getLeft(), sum, map, pathSum);
        count += dfsCount(treeNode.getRight(), sum, map, pathSum);
        map.put(pathSum, map.get(pathSum) - 1);
        return count;
    }
    
    private int maxPathSum(TreeNode root){
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    
    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null){
            return 0;
        }
        int[] maxLeftSum = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.getLeft(), maxLeftSum));
        int[] maxRightSum = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.getRight(), maxRightSum));
        maxSum[0] = Math.max(maxLeftSum[0], maxRightSum[0]);
        maxSum[0] = Math.max(maxSum[0], left + right + root.getVal());
        return Math.max(left + root.getVal(), right + root.getVal());
    }
    
    private TreeNode serchBST(TreeNode root, int val){
        TreeNode cur = root;
        while (cur != null){
            if (cur.getVal() == val){
                break;
            }
            if (cur.getVal() < val){
                cur = cur.getRight();
            }
            if (cur.getVal() > val){
                cur = cur.getLeft();
            }
        }
        return cur;
    }
    
    private TreeNode increasingBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            if (pre != null){
                pre.setRight(cur);
            }else {
                first = cur;
            }
            pre = cur;
            cur.setLeft(null);
            cur = cur.getRight();
        }
        return first;
    }
    
    public TreeNode inordersuccessor(TreeNode root, TreeNode target){
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        Boolean found = false;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            if (found){
                break;
            }else {
                if (cur == target){
                    found = true;
                }
            }
            cur = cur.getRight();
        }
        return cur;
    }
    
    public TreeNode inordersuccessor1(TreeNode root, TreeNode target){
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null){
            if (cur.getVal() > target.getVal()){
                result = cur;
                cur = cur.getLeft();
            }else {
                cur = cur.getRight();
            }
        }
        return result;
    }
    
    public TreeNode convertBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getRight();
            }
            cur = stack.pop();
            sum += cur.getVal();
            cur.setVal(sum);
            cur = cur.getLeft();
        }
        return root;
    }
    
    public boolean findTarget(TreeNode root, int v){
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            if (set.contains(v - cur.getVal())){
                return true;
            }
            set.add(cur.getVal());
            cur = cur.getRight();
        }
        return false;
    }
    
    public boolean findTarget1(TreeNode root, int v){
        BSTIterator bstIterator = new BSTIterator(root);
        BSTIteratorReserved bstIteratorReserved = new BSTIteratorReserved(root);
        int prev = bstIteratorReserved.prev();
        int next = bstIterator.next();
        while (prev != next){
            if (prev + next > v){
                prev = bstIteratorReserved.prev();
            }else if (prev + next < v){
                next = bstIterator.next();
            }else {
                return true;
            }
        }
        return  false;
    }
    
    public boolean containsAlmostNearbyDuplicate(int[] nums, int k, int t){
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && floor >= (nums[i] - t)){
                return true;
            }
            Integer ceil = treeSet.ceiling(nums[i]);
            if (ceil != null && ceil <= nums[i] - t){
                return true;
            }
            treeSet.add(nums[i]);
            if (i >= k){
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
    
    public boolean containsAlmostNearbyDuplicate1(int[] nums, int k, int t){
        int bucketSize = t + 1;
        Map<Integer, Integer> bucketMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucketId = getBucketId(nums[i], bucketSize);
            if (bucketMap.get(bucketId) != null){
                return true;
            }
            if (bucketMap.get(bucketId - 1) != null && Math.abs(nums[i] - bucketMap.get(bucketId - 1)) <= k){
                return true;
            }
            if (bucketMap.get(bucketId + 1) != null && Math.abs(nums[i] - bucketMap.get(bucketId + 1)) <= k){
                return true;
            }
            bucketMap.put(bucketId, nums[i]);
            if (i >= k){
                bucketMap.remove(getBucketId(nums[i - k], bucketSize));
            }
        }
        return false;
    }
    
    private int getBucketId(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : -(-num / bucketSize + 1);
    }
}
