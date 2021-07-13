package com.example;

/**
 *
 * @author Anzel
 */
public enum Ranks {
    
    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),    
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K");
    
    private final int id;
    private final String symbol;
    
    Ranks(int id, String symbol){
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
