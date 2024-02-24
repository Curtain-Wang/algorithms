package trie;

/**
 * @Author Curtain
 * @Date 2023/6/29 10:23
 * @Description
 */
public class T1 {
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (cur.getSonNodes()[word.charAt(i) - 'a'] == null){
                    cur.getSonNodes()[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.getSonNodes()[word.charAt(i) - 'a'];
            }
        }
        return root;
    }
    
    private void dfs(TrieNode trieNode, int[] result, int length){
        boolean isLeaf = true;
        for (TrieNode sonNode : trieNode.getSonNodes()) {
            if (sonNode != null){
                isLeaf = false;
                dfs(sonNode, result, length + 1);
            }
        }
        if (isLeaf){
            result[0] += length;
        }
    }
    
    private int miniLengthEncoding(String[] words){
        TrieNode root = buildTrie(words);
        int[] result = new int[]{0};
        dfs(root, result, 1);
        return result[0];
    }
}
