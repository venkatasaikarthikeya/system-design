package ads.tries;

/**
 * Learnt from takeuforward.org
 */
public class TrieDriver {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apxl");
        trie.insert("bac");
        trie.insert("bat");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("appl"));
        System.out.println(trie.search("bat"));
        System.out.println(trie.search("bact"));
        System.out.println(trie.startsWith("app"));
        System.out.println("abc");
    }
}
