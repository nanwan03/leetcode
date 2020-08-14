class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next;
    boolean end;
    public TrieNode() {
        next = new TrieNode[26];
        end = false;
    }
}

public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    public boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.end;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
                return search(word, index + 1, node);
            } else {
                return false;
            }
        } else {
            for (TrieNode child : node.next) {
                if (child != null) {
                    boolean flag = search(word, index + 1, child);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");