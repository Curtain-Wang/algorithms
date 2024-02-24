package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/25 10:29
 * @Description
 * 
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 * 我们可以按以下步骤为二维区域构建四叉树：
 *
 * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 * 使用适当的子网格递归每个子节点。
 * 
 * 提示：
 *
 * n == grid.length == grid[i].length
 * n == 2^x 其中 0 <= x <= 6
 */
public class T427 {
    int[][] grid = null;
    
    public static void main(String[] args) {
//        System.out.println(new T427().construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}}));
        System.out.println(new T427().construct(new int[][]{{0,1},{1,0}}));
    }
    
    public Node construct(int[][] grid) {
        this.grid = grid;
        return dfs(0, grid[0].length - 1, 0, grid.length - 1);
    }
    
    private Node dfs(int colStart, int colEnd, int rowStart, int rowEnd) {
        //说明已经到最小值了
        if (colStart == colEnd){
            return new Node(grid[rowStart][colStart] == 1, true);
        }
        Node root = new Node();
        root.topLeft = dfs(colStart, colStart + colEnd >> 1, rowStart, rowStart + rowEnd >> 1);
        root.topRight = dfs((colStart + colEnd >> 1) + 1, colEnd, rowStart, rowStart + rowEnd >> 1);
        root.bottomLeft = dfs(colStart, colStart + colEnd >> 1, (rowStart + rowEnd >> 1) + 1, rowEnd);
        root.bottomRight = dfs((colStart + colEnd >> 1) + 1, colEnd, (rowStart + rowEnd >> 1) + 1, rowEnd);
        //四个角都是叶子，则需要判断四个角的值是否相等
        if (root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf && root.topLeft.val == root.topRight.val && root.topRight.val == root.bottomLeft.val && root.bottomLeft.val == root.bottomRight.val){
            root.isLeaf = true;
            root.val = root.topRight.val;
            root.topLeft = null;
            root.topRight = null;
            root.bottomLeft = null;
            root.bottomRight = null;
        }else { //存在不是叶子的节点
            root.isLeaf = false;
            root.val = false;
            
        }
        return root;
    }
    
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        
        
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
