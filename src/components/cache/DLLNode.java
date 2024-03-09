package components.cache;

public class DLLNode {
    public DLLNode previous;
    public Integer key;
    public Integer value;
    public DLLNode next;

    DLLNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
