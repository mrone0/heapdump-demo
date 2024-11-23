package com.mrone.heapdump.util;

import com.mrone.heapdump.entity.Like;
import com.mrone.heapdump.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CacheUtil {
    private static final WeakHashMap<Integer, Like> weak = new WeakHashMap<>();
    private static final Lock lock = new ReentrantLock();

    private static final List<User> cache = new ArrayList<>();


    public static void put(Like like) {
        lock.lock();
        try {
            weak.put(like.getUser().getId(), like);
        } finally {
            lock.unlock();
        }
    }

    public static void add(User user) {
        lock.lock();
        cache.add(user);
    }
}
