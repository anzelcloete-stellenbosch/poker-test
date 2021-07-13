package com.example;

import java.util.Stack;

/**
 *
 * @author Anzel
 */
public class Deck {
    
    private final Stack<Card> cards = new Stack<Card>();
    
    public Deck(){
    	//Initialize all the different ranks for each suit in the deck
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                cards.push(new Card(suit, rank));
            }            
        }         
    }

    public Stack<Card> getCards() {
        return cards;
    }
    
    //A function to randomly change the order of the cards in the deck
    public void shuffle(){
        for(int i=0; i< cards.size(); i++){
            int j = (int)(Math.random() * ((cards.size())));
            
            Card temp = cards.pop();
            cards.add(j, temp);              
            
        }
    }
    
    //A functiom to draw a number of cards from the deck. They are not placed back after dealt
    public Card[] dealHand(int length){
        if(length < cards.size()){
            Card[] hand = new Card[length];
            for(int i = 0; i<length; i++){
                hand[i] = cards.get(i);
            }
            return hand;            
        }
        return null;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(Card card : cards){
            sb.append(card.toString());
        }
        sb.append(cards.size());
        return sb.toString();
    }
}
