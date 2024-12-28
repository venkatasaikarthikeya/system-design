package ads.tries;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.getData()[idx] == null) {
                current.getData()[idx] = new TrieNode();
            }
            current = current.getData()[idx];
        }
        current.setWordEnd(true);
    }

    public boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.getData()[idx] == null) {
                return false;
            }
            current = current.getData()[idx];
        }
        return current.getWordEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (current.getData()[idx] == null) {
                return false;
            }
            current = current.getData()[idx];
        }
        return true;
    }
}
