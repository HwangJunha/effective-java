package org.around.presentation.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserArray {
    private final Object[] choiceArray;

    public ChooserArray(Collection choices){
        choiceArray = choices.toArray();
    }
    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
    public static void main(String[] args) {
        List<String> stringList = List.of("1","2","3","4","5");
        ChooserArray chooserArray = new ChooserArray(stringList);
        for (int i = 0; i < 10; i++) {
            Number choice = (Number)chooserArray.choose();
            System.out.println(choice);
        }
    }
}
