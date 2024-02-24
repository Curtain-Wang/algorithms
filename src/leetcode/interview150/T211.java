package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/8 10:57
 * @Description
 * 
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * 
 * 1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 104 次 addWord 和 search
 */
public class T211 {
}
class WordDictionary {
    TreeNode root = new TreeNode();
    public WordDictionary() {
        
    }
    public void addWord(String word) {
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
        return dfs(cur, word, 0);
    }
    
    private boolean dfs(TreeNode cur, String word, int i) {
        if (i == word.length()){
            return cur.isWord;
        }
        char ch = word.charAt(i);
        if (ch != '.' && cur.sons[ch - 'a'] == null){
            return false;
        }
        if (ch != '.'){
            return dfs(cur.sons[ch - 'a'], word, i + 1);
        }
        boolean ans = false;
        for (TreeNode son : cur.sons) {
            if (son != null){
                ans = ans || dfs(son, word, i + 1);
            }
        }
        return ans;
    }
    
    class TreeNode{
        TreeNode[] sons = new TreeNode[26];
        boolean isWord;
    }
}
