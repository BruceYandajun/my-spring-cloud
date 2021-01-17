package com.github.bruce.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheJDK extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheJDK(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheJDK cache = new LRUCacheJDK(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println(cache);
        cache.put(3, 3);
        System.out.println(cache);
    }
}
