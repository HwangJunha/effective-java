package org.around.item45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// 반복 방식과 스트림 방식으로 두 리스트의 데카르트 곱을 생성한다. (275-276쪽)
public class Card {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
                       EIGHT, NINE, TEN, JACK, QUEEN, KING }

    private final Suit suit;
    private final Rank rank;

    @Override public String toString() {
        return rank + " of " + suit + "S";
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }
    private static final List<Card> NEW_DECK = primitiveNewDeck();

    // 코드 45-4 데카르트 곱 계산을 반복 방식으로 구현 (275쪽)
//    private static List<Card> newDeck() {
//        List<Card> result = new ArrayList<>();
//        for (Suit suit : Suit.values())
//            for (Rank rank : Rank.values())
//                result.add(new Card(suit, rank));
//        return result;
//    }

    // 코드 45-5 데카르트 곱 계산을 스트림 방식으로 구현 (276쪽)
//    private static List<Card> newDeck() {
//        return Stream.of(Suit.values())
//                .flatMap(suit ->
//                        Stream.of(Rank.values())
//                                .map(rank -> new Card(suit, rank)))
//                .collect(toList());
//    }
    //코드 45-5의 flatMap의 원시적인 코드
    private static List<Card> primitiveNewDeck(){
        List<Card> spadeCards = Stream.of(Rank.values())
                .map(rank -> new Card(Suit.SPADE, rank))
                .collect(toList());

        List<Card> heartCards = Stream.of(Rank.values())
                .map(rank -> new Card(Suit.HEART, rank))
                .collect(toList());

        List<Card> diamondCards = Stream.of(Rank.values())
                .map(rank -> new Card(Suit.DIAMOND, rank))
                .collect(toList());

        List<Card> clubCards = Stream.of(Rank.values())
                .map(rank -> new Card(Suit.CLUB, rank))
                .collect(toList());
        List<Card> resultCard = new ArrayList<>();
        resultCard.addAll(spadeCards);
        resultCard.addAll(heartCards);
        resultCard.addAll(diamondCards);
        resultCard.addAll(clubCards);

        return resultCard;
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}
