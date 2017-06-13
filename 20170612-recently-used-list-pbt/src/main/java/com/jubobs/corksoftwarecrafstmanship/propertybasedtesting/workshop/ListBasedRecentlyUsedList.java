package com.jubobs.corksoftwarecrafstmanship.propertybasedtesting.workshop;

import java.util.ArrayList;
import java.util.List;

public final class ListBasedRecentlyUsedList<T> implements RecentlyUsedList<T> {

    private List list;
    private int capacity;

    private ListBasedRecentlyUsedList(int capacity) {
        this.capacity = capacity;
        list = new ArrayList(capacity);
    }

    public static <T> ListBasedRecentlyUsedList<T> newInstance(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("List can not be instantiated with non positive capacity");
        }
        return new ListBasedRecentlyUsedList<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void push(T newHead) {
        if (newHead == null) {
            throw new IllegalArgumentException("Null items can not be added to the list");
        }
        list.add(newHead);
    }

    @Override
    public T elementAt(int index) {
        return (T) list.get(index);
    }

    @Override
    public List<T> toList() {
        return null;
    }

}

