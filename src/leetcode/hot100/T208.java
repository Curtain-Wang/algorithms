package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/13 10:21
 * @Description
 */
public class T208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }     
}

class Trie {
    
    Trie[] tries;
    boolean wordend;
    
    public Trie() {
        tries = new Trie[26];
        wordend = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i)- 'a';
            if (node.tries[index] == null){
                node.tries[index] = new Trie();
            }
            node = node.tries[index];
        }
        node.wordend = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.wordend;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    
    public Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node == null){
                return null;
            }else {
                node = node.tries[prefix.charAt(i) - 'a'];
            }
        }
        return node;
    }
}