package ads.tries;

public class TrieNode {

    private TrieNode[] data;
    private boolean wordEnd;

    public TrieNode() {
        this.data = new TrieNode[26];
        this.wordEnd = false;
    }

    public TrieNode[] getData() {
        return data;
    }

    public void setData(TrieNode[] data) {
        this.data = data;
    }

    public boolean getWordEnd() {
        return wordEnd;
    }

    public void setWordEnd(Boolean wordEnd) {
        this.wordEnd = wordEnd;
    }
}
