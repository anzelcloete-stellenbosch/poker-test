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
        
        myObj = new Scanner(System.in);
        String exit;

        do{
            deck.shuffle();
            System.out.println("Shuffling...");
            Card[] handOfFive = deck.dealHand(5); //Dealing 5 cards for a hand, it can be changed
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
