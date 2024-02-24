package trie;

class TrieNode {
        private TrieNode[] sonNodes;
        private boolean isWord;
        private int val;
    
        public TrieNode(boolean isWord) { 
            this.isWord = isWord;
            this.sonNodes = new TrieNode[26];
        }
    
        public TrieNode() {
            this.sonNodes = new TrieNode[26];
            this.isWord = false;
        }
    
        public TrieNode[] getSonNodes() {
            return sonNodes;
        }
    
        public void setSonNodes(TrieNode[] sonNodes) {
            this.sonNodes = sonNodes;
        }
    
        public boolean isWord() {
            return isWord;
        }
    
        public void setWord(boolean word) {
            isWord = word;
        }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
}