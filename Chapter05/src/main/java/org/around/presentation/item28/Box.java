package org.around.presentation.item28;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Number> {
    List<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T getValue(int i) {
        return list.get(i);
    }
}