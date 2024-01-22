package org.around.presentation.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserGeneric<T> {
    private final List<T> choiceList;

    public ChooserGeneric(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        ChooserGeneric<Integer> chooserGeneric = new ChooserGeneric<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = chooserGeneric.choose();
            System.out.println(choice);
        }
    }
}
