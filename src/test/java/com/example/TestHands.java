package com.example;

import org.junit.Assert;
import org.junit.Test;

import com.example.Card;
import com.example.Hand;
import com.example.Ranks;
import com.example.Suits;
/**
 *
 * @author Anzel
 */
public class TestHands {

	    @Test
	    public void testHighCards() {
	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
	    new Card(Suits.HEARTS, Ranks.TWO)
	    ,new Card(Suits.CLUBS, Ranks.NINE)
	    ,new Card(Suits.DIAMONDS, Ranks.KING)
	    ,new Card(Suits.SPADES, Ranks.JACK)};
	     Assert.assertEquals("High Card", Hand.handType(handOfFive));
	    }
	    
        @Test
        public void testOnePair() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
   	  	    new Card(Suits.HEARTS, Ranks.TWO)
   	  	    ,new Card(Suits.CLUBS, Ranks.JACK)
   	  	    ,new Card(Suits.DIAMONDS, Ranks.KING)
   	  	    ,new Card(Suits.SPADES, Ranks.JACK)};
         Assert.assertEquals("One Pair", Hand.handType(handOfFive));
        }

        @Test
        public void testTwoPair() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
   	  	    new Card(Suits.HEARTS, Ranks.ACE)
   	  	    ,new Card(Suits.CLUBS, Ranks.NINE)
   	  	    ,new Card(Suits.DIAMONDS, Ranks.NINE)
   	  	    ,new Card(Suits.SPADES, Ranks.SIX)};
         Assert.assertEquals("Two Pair", Hand.handType(handOfFive));
        } 
        
        @Test
        public void testThreeOfAKind() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
   	  	    new Card(Suits.HEARTS, Ranks.TWO)
   	  	    ,new Card(Suits.CLUBS, Ranks.KING)
   	  	    ,new Card(Suits.DIAMONDS, Ranks.KING)
   	  	    ,new Card(Suits.SPADES, Ranks.KING)};
         Assert.assertEquals("Three of a Kind", Hand.handType(handOfFive));
        }
        
        @Test
        public void testFourOfAKind() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
   	  	    new Card(Suits.HEARTS, Ranks.ACE)
   	  	    ,new Card(Suits.CLUBS, Ranks.ACE)
   	  	    ,new Card(Suits.DIAMONDS, Ranks.ACE)
   	  	    ,new Card(Suits.SPADES, Ranks.JACK)};
         Assert.assertEquals("Four of a Kind", Hand.handType(handOfFive));
        }
        
        @Test
        public void testStraight() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.SIX),
   	  	    new Card(Suits.CLUBS, Ranks.TWO)
   	  	    ,new Card(Suits.HEARTS, Ranks.THREE)
   	  	    ,new Card(Suits.CLUBS, Ranks.FOUR)
   	  	    ,new Card(Suits.CLUBS, Ranks.FIVE)};
         Assert.assertEquals("Straight", Hand.handType(handOfFive));
        }
        
        @Test
        public void testFlush() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.HEARTS, Ranks.TWO),
   	  	    new Card(Suits.HEARTS, Ranks.TEN)
   	  	    ,new Card(Suits.HEARTS, Ranks.SEVEN)
   	  	    ,new Card(Suits.HEARTS, Ranks.KING)
   	  	    ,new Card(Suits.HEARTS, Ranks.EIGHT)};
         Assert.assertEquals("Flush", Hand.handType(handOfFive));
        } 
        
        @Test
        public void testRoyalFlush() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.ACE),
   	  	    new Card(Suits.CLUBS, Ranks.TEN)
   	  	    ,new Card(Suits.CLUBS, Ranks.JACK)
   	  	    ,new Card(Suits.CLUBS, Ranks.QUEEN)
   	  	    ,new Card(Suits.CLUBS, Ranks.KING)};
         Assert.assertEquals("Royal Flush", Hand.handType(handOfFive));
        }
        
        @Test
        public void testStraightFlush() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.SIX),
   	  	    new Card(Suits.CLUBS, Ranks.SEVEN)
   	  	    ,new Card(Suits.CLUBS, Ranks.THREE)
   	  	    ,new Card(Suits.CLUBS, Ranks.FOUR)
   	  	    ,new Card(Suits.CLUBS, Ranks.FIVE)};
         Assert.assertEquals("Straight Flush", Hand.handType(handOfFive));
        }
        
        @Test
        public void testFullHouse() {
   	     Card[] handOfFive = new Card[] {new Card(Suits.CLUBS, Ranks.THREE),
   	  	    new Card(Suits.DIAMONDS, Ranks.THREE)
   	  	    ,new Card(Suits.HEARTS, Ranks.THREE)
   	  	    ,new Card(Suits.CLUBS, Ranks.FIVE)
   	  	    ,new Card(Suits.SPADES, Ranks.FIVE)};
         Assert.assertEquals("Full House", Hand.handType(handOfFive));
        }
}
