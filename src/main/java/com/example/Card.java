package com.example;

/**
 *
 * @author Anzel
 */
public class Card implements Comparable<Object>{
    
    private final Suits suit;
    private final Ranks rank;
    
    public Card(Suits suit, Ranks rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return rank.getSymbol() + suit.getSymbol();
    }

    @Override
    public int compareTo(Object o) {
        return this.rank.getId() - ((Card) o).getRank().getId();
    }
    
    
}
