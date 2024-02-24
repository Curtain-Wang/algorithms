package trie;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/6/28 15:08
 * @Description
 */
public class Practice {
    
    private TrieNode buildTrie(List<String> dicts){
        TrieNode root = new TrieNode();
        for (String dict : dicts) {
            TrieNode cur = root;
            for (char ch : dict.toCharArray()) {
                if (cur.getSonNodes()[ch - 'a'] == null){
                    cur.getSonNodes()[ch - 'a'] = new TrieNode();
                }
                cur = cur.getSonNodes()[ch - 'a'];
            }
            cur.setWord(true);
        }
        return root;
    }
    
    private String findPrefix(TrieNode root, String word){
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (cur.isWord() || cur.getSonNodes()[ch - 'a'] == null){
                break;
            }
            sb.append(ch);
            cur = cur.getSonNodes()[ch - 'a'];
        }
        return cur.isWord() ? new String(sb) : "";
    }
    
    private String replaceWords(List<String> dicts, String sentence){
        TrieNode root = buildTrie(dicts);
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String prefix = findPrefix(root, word);
            if (!"".equals(prefix)){
                word = prefix;
            }
            stringBuilder.append(" ").append(word);
        }
        return stringBuilder.toString();
    }
    
    private boolean search(List<String> dicts, String word){
        TrieNode root = buildTrie(dicts);
        return dfs(root, word, 0, 0);
    }
    
    private boolean dfs(TrieNode root, String word, int dictLength, int editTimes) {
        TrieNode cur = root;
        TrieNode[] sonNodes = cur.getSonNodes();
        if (cur == null || editTimes > 1 || word.length() < dictLength + 1){
            return false;
        }
        boolean found = false;
        for (int i = 0; i < sonNodes.length && !found; i++) {
            if (sonNodes[i] == null){
                continue;
            }
            if (word.length() > dictLength + 1){
                if (i == (word.charAt(dictLength) - 'a')){
                    found =  dfs(sonNodes[i], word, dictLength + 1, editTimes);
                }else {
                    found = dfs(sonNodes[i], word, dictLength + 1, editTimes + 1);
                }
            }
            if (i == (word.charAt(dictLength) - 'a') && editTimes == 1 && cur.isWord()){
                found =  true;
            }else if (i != word.charAt(dictLength) - 'a' && editTimes == 0 && cur.isWord()){
                found = false;
            }
        }
        return found;
    }
    
    private boolean dfs1(TrieNode root, String word, int dictLength, int editTimes){
        if (root == null){
            return false;
        }
        if (root.isWord() && word.length() == dictLength && editTimes == 1){
            return true;
        }
        if (word.length() < dictLength && editTimes <= 1){
            TrieNode[] sonNodes = root.getSonNodes();
            boolean found = false;
            for (int i = 0; i < sonNodes.length && !found; i++) {
                editTimes = i == word.charAt(dictLength) - 'a' ? editTimes : editTimes + 1;
                found = dfs1(sonNodes[i], word, dictLength, editTimes);
            }
        }
        return false;
    }
    
    
}
