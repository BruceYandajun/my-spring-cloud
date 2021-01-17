package com.github.bruce.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode next;
        DLinkNode prev;
        public DLinkNode() {

        }
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    DLinkNode head;
    DLinkNode tail;

    int size;
    int capacity;

    Map<Integer, DLinkNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new DLinkNode(key, value);
        addToHead(node);
        size ++;
        map.put(key, node);
        if (size > capacity) {
            DLinkNode last = removeTail();
            map.remove(last.key);
            size --;
        }
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkNode removeTail() {
        DLinkNode last = tail.prev;
        removeNode(last);
        return last;
    }
}
