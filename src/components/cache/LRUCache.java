package components.cache;

import java.util.HashMap;

class DoublyLinkedList {

    DLLNode head;
    DLLNode tail;

    DoublyLinkedList() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);

        // head's previous and tail's next will always point to null
        head.previous = null;
        tail.next = null;

        // point the head's next to tail and tail previous to head
        head.next = tail;
        tail.previous = head;
    }

    void plugTheNodeOut(DLLNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    void plugTheNodeInTheFront(DLLNode node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    DLLNode insert(Integer key, Integer value) {
        DLLNode newNode = new DLLNode(key, value);
        plugTheNodeInTheFront(newNode);
        return newNode;
    }

    void update(Integer value, DLLNode toBeUpdated) {
        toBeUpdated.value = value;
        plugTheNodeOut(toBeUpdated);
        plugTheNodeInTheFront(toBeUpdated);
    }

    DLLNode delete() {
        DLLNode toBeDeleted = tail.previous;
        tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;
        return toBeDeleted;
    }

    void printList() {
        StringBuilder builder = new StringBuilder();
        builder.append("HEAD -> ");
        for (DLLNode temp = head.next; temp != tail; temp = temp.next) {
            String s = "key: " + temp.key + ", value: " + temp.value + " -> ";
            builder.append(s);
        }
        builder.append("TAIL");
        System.out.println(builder);
    }
}

public class LRUCache {

    private Integer capacity;
    private final DoublyLinkedList dll;
    private final HashMap<Integer, DLLNode> lruCache;

    LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.dll = new DoublyLinkedList();
        this.lruCache = new HashMap<>();
    }

    Integer get(Integer key) {
        if (lruCache.containsKey(key)) {
            DLLNode node = lruCache.get(key);
            dll.plugTheNodeOut(node);
            dll.plugTheNodeInTheFront(node);
            return node.value;
        } else {
            return -1;
        }
    }

    void put(Integer key, Integer value) {
        if (lruCache.containsKey(key)) {
            DLLNode node = lruCache.get(key);
            dll.update(value, node);
        } else {
            if (lruCache.size() == capacity) {
                DLLNode node = dll.delete();
                lruCache.remove(node.key);
            }
            DLLNode node = dll.insert(key, value);
            lruCache.put(key, node);
        }
    }

    void  print() {
        dll.printList();
    }
}
