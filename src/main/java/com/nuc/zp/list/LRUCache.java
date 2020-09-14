package com.nuc.zp.list;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, DoubleLinkedNode> cacheMap;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    int size;

    public LRUCache(int capacity) {
        size = capacity;
        cacheMap = new HashMap<>();
        head = new DoubleLinkedNode(0, 0);
        tail = new DoubleLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode node = cacheMap.get(key);
        delete(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DoubleLinkedNode node = cacheMap.get(key);
            delete(node);
            node.value = value;
            add(node);
        } else {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            add(newNode);
            cacheMap.put(key, newNode);
        }
    }

    private void delete(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;

        cacheMap.remove(node.key);
    }

    private void add(DoubleLinkedNode newNode) {
        insertQueue(newNode);
        cacheMap.put(newNode.key, newNode);
        if (cacheMap.size() > size) {
            DoubleLinkedNode toDelete = tail.prev;
            delete(toDelete);
            cacheMap.remove(toDelete.key);

        }
    }

    private void insertQueue(DoubleLinkedNode newNode) {
        DoubleLinkedNode oldFirst = head.next;
        head.next = newNode;
        oldFirst.prev = newNode;
        newNode.prev = head;
        newNode.next = oldFirst;
    }

    static class DoubleLinkedNode {
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        int key;
        int value;

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */