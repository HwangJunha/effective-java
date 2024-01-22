package org.around.presentation.item28;

public class Generic<T> {
    private final T obj;

    public Generic(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args){

        Long[] longArray = new Long[1];
        longArray[0] = 1L;
    }
}
