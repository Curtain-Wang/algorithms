package trie;

/**
 * @Author Curtain
 * @Date 2023/6/29 13:42
 * @Description
 */
public class T2 {
    
    
    
    private TrieNode buildTrie(int[] nums){
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.sonNodes[bit] == null){
                    cur.sonNodes[bit] = new TrieNode();
                }
            }
        }
        return root;
    }
    
    private int findMaxXor(int[] nums){
        TrieNode root = buildTrie(nums);
        int maxXor = 0;
        for (int num : nums) {
            int xor = 0;
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.sonNodes[1 - bit] != null){
                    xor += (1 << i);
                    cur = cur.sonNodes[1 - bit];
                }else {
                    cur = cur.sonNodes[bit];
                }
            }
            maxXor = Math.max(maxXor, xor);
        }
        return maxXor;
    }
    
    private int findMaxXor1(int[] nums){
        TrieNode root = buildTrie(nums);
        int maxXor = 0;
        for (int num : nums) {
            int xor = 0;
            TrieNode cur = root;
            for (int i = 31; i >= 0 ; i--) {
                int bit = (num >> i) & 1;
                xor = xor << 1;
                if (cur.sonNodes[1 - bit] != null){
                    xor += 1;
                    cur = cur.sonNodes[1 - bit];
                }else {
                    cur = cur.sonNodes[bit];
                }
            }
            maxXor = Math.max(maxXor, xor);
        }
        return maxXor;
    }
    
    static class TrieNode{
        TrieNode[] sonNodes;
    
        public TrieNode() {
            this.sonNodes = new TrieNode[2];
        }
    }
}
