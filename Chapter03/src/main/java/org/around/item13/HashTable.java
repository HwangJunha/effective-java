package org.around.item13;

import java.util.Map;

public class HashTable implements Cloneable{
    private Entry[] buckets = new Entry[3];
    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //잘 못된 clone 메서드 - 가변 상태를 공유한다.
    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
