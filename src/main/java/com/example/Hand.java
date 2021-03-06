package com.example;

import java.util.Arrays;

//The following class was adapted from https://github-dotcom.gateway.web.tr/rachelvansciver/PokerHandAnalyzer

public class Hand {

    public static String handType(Card[] hand) {
        int[] values = tallyValues(hand);
        int[] suits = tallySuits(hand);
        if (isRoyalFlush(hand, suits)) {
            return "Royal Flush";
        } else if (isStraightFlush(hand, suits)) {
            return "Straight Flush";
        } else if (isFourOfAKind(values)) {
            return "Four of a Kind";
        } else if (isFullHouse(values)) {
            return "Full House";
        } else if (isFlush(suits)) {
            return "Flush";
        } else if (isStraight(hand)) {
            return "Straight";
        } else if (isThreeOfAKind(values)) {
            return "Three of a Kind";
        } else if (isTwoPair(values)) {
            return "Two Pair";
        } else if (isPair(values)) {
            return "One Pair";
        } else {
            return "High Card";
        }
    }

    public static Card[] sort(Card[] hand) {
        Arrays.sort(hand);
        return hand;
    }

    public static boolean isStraight(Card[] hand) {
        hand = sort(hand);
        if (hand.length < 5) {
            //if less than 5 cards cannot be straight
            return false;
        }
        boolean isStraight = true;

        int i = 0;
        while (i < hand.length - 1) {
            //looks at next and current card value
            int current = hand[i].getRank().getId();
            int next = hand[i + 1].getRank().getId();

            if (next > current + 1 && !(current == 1 && next == 10)) { 
            	// Added the second part of the condition specifically for a royal straight 
            	//i.e ACE,TEN,JACK,QUEEN,KING
                //if next card is more than one greater it is not a straight
                isStraight = false;
                break;
            }
            i++;
        }
        return isStraight;
    }

    public static boolean isFlush(int[] suits) {
        /**
         * Looks at tally of each suit. If a suit has a tally of 5 cards, it is
         * a flush (all cards have the same suit)
         */
        if (suits.length != 4) {
            return false;
        }
        for (int i = 0; i < suits.length; i++) {
            if (suits[i] == 5) {
                return true;
            }
        }
        return false;
    }

    public static int[] tallyValues(Card[] hand) {
        //Storing a tally of each value of card
        int[] values = new int[14];
        for (int i = 0; i < hand.length; i++) {
            /*increments value at that index(adds to tally) and adds it to tally array*/

            values[hand[i].getRank().getId()]++;
        }
        return values;
    }

    public static int[] tallySuits(Card[] hand) {
        //tallying  how many suits are of each type
        int[] suits = new int[4];
        for (int i = 0; i <= suits.length; i++) {
            //adds tally to respective suit. 0 - Spades,1 - Hearts, 2 - Clubs, 3 - Diamonds
            suits[hand[i].getSuit().getId()]++;
        }
        return suits;
    }

    public static boolean isPair(int[] values) {
        //Finding if there are pairs
        int pairs = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 2) {
                pairs++;
            }
        }
        if (pairs == 1) {
            //if there is a pair return true else return false
            return true;
        }
        return false;
    }

    public static boolean isTwoPair(int[] values) {
        //if there is two pairs return true
        int pairs = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 2) {
                pairs++;
            }
        }
        if (pairs == 2) {
            return true;
        }
        return false;

    }

    public static boolean isThreeOfAKind(int[] values) {
        //Three cards of the same value
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFourOfAKind(int[] values) {
        //Four cards of the same value
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullHouse(int[] values) {
        //evaluates if has pair and has three
        boolean hasPair = false;
        boolean hasThree = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 3 && !hasThree) {
                //if has three and has three isn't true, has three is now true.
                hasThree = true;
            } else if (values[i] >= 2) {
                //if has a pair, hasPair = true
                hasPair = true;
            }
        }
        return (hasPair && hasThree);
    }

    public static boolean isStraightFlush(Card[] hand, int[] suits) {
        //evaluates if card is straight and flush to determine if a straight flush
        return (isStraight(hand) && isFlush(suits));

    }

    public static boolean isRoyalFlush(Card[] hand, int[] suits) {
        //evaluates if card is straight and flush and first card is an ace
        return (isStraight(hand) && isFlush(suits) && hand[0].getRank() == Ranks.ACE);
    }

}
