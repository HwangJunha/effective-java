package org.around.item02;

import org.around.item02.telescopingconstructor.NutritionFacts;

public class Item02 {
    public static void main(String[] args){
        //점층적 생성자 패턴
        NutritionFacts cocaCola1 = new NutritionFacts(240, 8, 100, 0, 35, 27);
        //자바 빈즈 패턴
        org.around.item02.javabeans.NutritionFacts cocaCola2 = new org.around.item02.javabeans.NutritionFacts();
        cocaCola2.setServingSize(240);
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setSodium(35);
        cocaCola2.setCarbohydrate(27);

        org.around.item02.builder.NutritionFacts cocaCola = new org.around.item02.builder.NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
    }
}
