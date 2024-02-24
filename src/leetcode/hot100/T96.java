package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/21 9:16
 * @Description
 * 
 * f(i): 表示以第i个为根节点,二叉搜索树的数量
 * g(n): 表示n个节点组成二叉搜索树的数量
 * f(i) = g(i - 1) * g(n - i)
 * g(n) = f(1) + ... + f(n) = g(0) * g(n - 1) + ... + g(n - 1) * g(0)
 */
public class T96 {
    
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[i - j] * g[j - 1];
            }
        }
        return g[n];
    }
}
