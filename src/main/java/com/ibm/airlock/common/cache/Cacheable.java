package com.ibm.airlock.common.cache;

import javax.annotation.Nullable;
import java.util.Set;

public interface Cacheable<K, T> {

    void put(K key, T value, long periodInMillis);

    void put(K key, T value);

    @Nullable
    T get(K key);

    boolean containsKey(K key);

    void remove(K key);

    Set<K> keySet();

    void clear();

    long size();
}
