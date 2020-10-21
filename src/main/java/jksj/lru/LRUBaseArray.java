package jksj.lru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUBaseArray<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private int capacity; // 容量
    private int count;    // 当前有多少个值
    private T[] value;
    private Map<T, Integer> holder;

    public LRUBaseArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>();
    }

    public void offer(T object) {
        if (object == null) throw new IllegalArgumentException("不支持空参数");
//        Integer index = holder.get(object);
        Integer index = getValueIndex(object);

        if (index == null){
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    private Integer getValueIndex(T object) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] == object) {
                return i;
            }
        }
        return null;
    }

    private void removeAndCache(T object) {
        T key = value[--count];
        cache(key, 0);
    }

    private void update(Integer index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    private void rightShift(Integer index) {
        for (int i = index -1; i>=0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i+1);
        }
    }

    private void cache(T object, Integer index) {
        rightShift(index);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    private boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        return "LRUBaseArray{" +
                "capacity=" + capacity +
                ", count=" + count +
                ", value=" + Arrays.toString(value) +
                ", holder=" + holder +
                '}';
    }

    public static void main(String[] args) {
        LRUBaseArray<String> lruBaseArray = new LRUBaseArray<String>();
        lruBaseArray.offer("a");
        lruBaseArray.offer("b");
        lruBaseArray.offer("c");
        lruBaseArray.offer("d");
        lruBaseArray.offer("e");
        lruBaseArray.offer("f");
        lruBaseArray.offer("g");
        lruBaseArray.offer("h");
        lruBaseArray.offer("a");
        lruBaseArray.offer("b");

        System.out.println(lruBaseArray);
    }

}
