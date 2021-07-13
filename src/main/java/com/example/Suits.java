package com.example;

/**
 *
 * @author Anzel
 */
public enum Suits {
    
    HEARTS(1, "\u2665"),
    DIAMONDS(2, "\u2666"),
    CLUBS(3, "\u2663"),
    SPADES(0, "\u2660");
    
    private final int id;
    private final String symbol;
    
    Suits(int id, String symbol){
        this.id = id;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    
    
}
