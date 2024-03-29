package org.around.item79;

import java.util.HashSet;

// ObservableSet 동작 확인 #1 - 0부터 99까지 출력한다. (422쪽)
public class Test1 {
    public static void main(String[] args) {
        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        //행동을 넣어놨다
        set.addObserver((s,e) -> {
            System.out.println(e);
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
