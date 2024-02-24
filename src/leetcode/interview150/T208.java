package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/8 10:45
 * @Description
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class T208 {
}
class Trie {
    TreeNode root = new TreeNode();
    public Trie() {
        
    }
    
    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.sons[word.charAt(i) - 'a'] == null){
                cur.sons[word.charAt(i) - 'a'] = new TreeNode();
            }
            if (i == word.length() - 1){
                cur.sons[word.charAt(i) - 'a'].isWord = true;
            }
            cur = cur.sons[word.charAt(i) - 'a'];
        }
    }
    
    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.sons[word.charAt(i) - 'a'] == null){
               return false;
            }
            if (i == word.length() - 1){
                return cur.sons[word.charAt(i) - 'a'].isWord;
            }
            cur = cur.sons[word.charAt(i) - 'a'];
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.sons[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            cur = cur.sons[prefix.charAt(i) - 'a'];
        }
        return true;
    }
    
    class TreeNode {
        TreeNode[] sons = new TreeNode[26];
        boolean isWord;
    }
}

