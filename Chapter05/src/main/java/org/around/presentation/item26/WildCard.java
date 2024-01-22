package org.around.presentation.item26;

import java.util.HashSet;
import java.util.Set;

public class WildCard {
    static int numElementsInCommon(Set s1, Set s2){
        int result = 0;
        for(Object o1 : s1) {
            s2.add(o1);
        }
        return result;

    }
    public static void main(String[] args){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<String> set2 = new HashSet<>();
        set2.add("3");
        set2.add("4");
        set2.add("5");
        System.out.println(numElementsInCommon(set1, set2));
        for (String s : set2){
            System.out.println(s);
        }
        System.out.println("");
    }
}
