package com.jubobs.corksoftwarecrafstmanship.propertybasedtesting.workshop;

import java.util.ArrayList;
import java.util.List;

public final class ListBasedRecentlyUsedList<T> implements RecentlyUsedList<T> {

    private List list;

    private ListBasedRecentlyUsedList(int capacity) {
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
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void clear() {

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
        return null;
    }

    @Override
    public List<T> toList() {
        return null;
    }

}

