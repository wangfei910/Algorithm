package Algorithm.Test.LRU;

import java.util.Hashtable;

/**
 * @author: wangfei
 * @date: 2019/5/9 9:54
 */
public class LRUCache {

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // should raise exception here
            return -1;
        }

        // move the accessed node to the head
        this.moveToHead(node);

        return node.value;
    }

    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(Integer.valueOf(key), newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head
     *
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list
     *
     * @param node
     */
    public void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head
     *
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail
     *
     * @return
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}
