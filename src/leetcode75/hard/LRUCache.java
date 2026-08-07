package leetcode75.hard;

import java.util.HashMap;

public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

    }

    // if get move the node to the front of the linked list
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;

    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        if (capacity == cache.size()) {
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);

        }
        Node newNode = new Node(key, value);
        addToFront(newNode);
        cache.put(key, newNode);
    }

    // helper methods to add and remove nodes from the linked list

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        check("get(1)", cache.get(1), 1);          // 1 becomes most recently used

        cache.put(3, 3);                            // evicts key 2 (least recently used)
        check("get(2)", cache.get(2), -1);           // evicted

        cache.put(4, 4);                             // evicts key 1
        check("get(1)", cache.get(1), -1);            // evicted
        check("get(3)", cache.get(3), 3);
        check("get(4)", cache.get(4), 4);

        // extra edge cases worth testing
        //LRUCache cache2 = new LRUCache(1);
        //cache2.put(10, 100);
        //check("cap=1 get(10)", cache2.get(10), 100);
        //cache2.put(20, 200);                          // evicts 10 immediately (capacity 1)
        //check("cap=1 get(10) after evict", cache2.get(10), -1);
        //check("cap=1 get(20)", cache2.get(20), 200);

        // updating an existing key should NOT evict, and should refresh recency
        //LRUCache cache3 = new LRUCache(2);
        //cache3.put(1, 1);
        //cache3.put(2, 2);
        //cache3.put(1, 111);                            // update key 1's value, 1 becomes MRU
        //check("update value get(1)", cache3.get(1), 111);
        //cache3.put(3, 3);                              // should evict 2, not 1
        //check("update recency get(2)", cache3.get(2), -1);
        //check("update recency get(1)", cache3.get(1), 111);

        //System.out.println("All checks passed!");
    }

    private static void check(String label, int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError(label + " -> expected " + expected + " but got " + actual);
        }
        System.out.println(label + " = " + actual + "  [OK]");
    }

}
