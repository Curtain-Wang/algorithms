package trie;

/**
 * @Author Curtain
 * @Date 2023/6/29 10:51
 * @Description
 */
public class MapSum {
    
    private TrieNode root;
    
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String word, int val){
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (cur.getSonNodes()[chars[i] - 'a'] == null){
                cur.getSonNodes()[chars[i] - 'a'] = new TrieNode();
            }
            cur = cur.getSonNodes()[chars[i] - 'a'];
        }
        cur.setVal(val);
    }
    
    public int sum(String prefix){
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.getSonNodes()[ch - 'a'] == null){
                return 0;
            }
            cur = cur.getSonNodes()[ch - 'a'];
        }
        int[] result = new int[]{0};
        dfs(cur,result);
        return result[0];
    }
    
    private void dfs(TrieNode node, int[] result) {
        if (node == null){
            return;
        }
        result[0] += node.getVal();
        TrieNode[] sonNodes = node.getSonNodes();
        for (TrieNode sonNode : sonNodes) {
            dfs(sonNode, result);
        }
    }
}
