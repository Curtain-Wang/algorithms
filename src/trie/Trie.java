package trie;

/**
 * @Author Curtain
 * @Date 2023/6/28 14:30
 * @Description
 */
public class Trie {
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String s){
        if (s == null || s == ""){
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            TrieNode[] sonNodes = cur.getSonNodes();
            if (sonNodes[s.charAt(i) - 'a'] == null){
                TrieNode trieNode = new TrieNode();
                sonNodes[s.charAt(i) - 'a'] = trieNode;
            }
            cur = sonNodes[s.charAt(i) - 'a'];
        }
        cur.setWord(true);
    }
    
    public boolean search(String word){
        if (word == null || word == "") {
            return true;
        }
        TrieNode cur = root;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            TrieNode[] sonNodes = cur.getSonNodes();
            if (sonNodes[wordChars[i] - 'a'] == null){
                return false;
            }
            cur = sonNodes[wordChars[i] - 'a'];
        }
        return cur.isWord();
    }
    
    public boolean startWith(String word){
        if (word == null || word == "") {
            return true;
        }
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.getSonNodes()[ch - 'a'] == null){
                return false;
            }
        }
        return true;
    }
    
   
}
