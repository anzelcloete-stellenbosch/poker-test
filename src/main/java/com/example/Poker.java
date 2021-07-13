package com.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Anzel
 */
public class Poker {

    private static Scanner myObj;

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();     
        System.out.println(deck);
        
        myObj = new Scanner(System.in);
        String exit;
        //For the purpose of the game, I draw 5 cards from the deck with every iteration
        //without putting them back in.
        //They game ends if there are no more cards left for a full hand or if the player quits.
        do{
            deck.shuffle();
            System.out.println("Shuffling...");
            Card[] handOfFive = deck.dealHand(5);
            if(handOfFive != null){
                Arrays.sort(handOfFive);
                System.out.println("Your hand: " + Arrays.toString(handOfFive));
                System.out.println("You have: " + Hand.handType(handOfFive));
                System.out.println("Deal a new hand? (yes)?");
                exit = myObj.nextLine();                
            } else{
                System.out.println("Not enough cards left in the deck to deal a hand");
                exit = "no";
            }
        }
        while("yes".equalsIgnoreCase(exit) || "y".equalsIgnoreCase(exit));
        System.out.println("Thank you for playing");
    }
    
}
