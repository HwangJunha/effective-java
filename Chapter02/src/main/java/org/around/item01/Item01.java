package org.around.item01;

public class Item01 {
    public static void main(String[] args) {
        System.out.println(valueOf(true));
        System.out.println(valueOf(false));
    }
    public static Boolean valueOf(boolean b){
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}