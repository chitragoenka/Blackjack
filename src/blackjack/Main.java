package blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Say hi to the user
        System.out.println("Welcome to the game of Blackjack!");



        //Create and start the Game
        Game blackjack = new Game();

        //Testing
        // System.out.println(Suit.CLUB);
        //System.out.println(Rank.ACE + " has a value of " + Rank.ACE.rankValue);

//        //Test out the Card class
//        //Create a testCard - Queen of Hearts
//        Card testCard = new Card(Suit.HEART, Rank.QUEEN);
//        //Print it out
//        System.out.println(testCard);

//        //Make some cards and a deck
//        Deck testDeck = new Deck();
//        Card aCard = new Card(Suit.CLUB, Rank.QUEEN);
//        Card bCard = new Card(Suit.DIAMOND,Rank.ACE);
//        Card cCard = new Card(Suit.SPADE, Rank.SIX);
//        //Add the cards to the deck
//        testDeck.addCard(aCard);
//        testDeck.addCard(bCard);
//        testDeck.addCard(cCard);
//        //Print out the deck
//        System.out.println(testDeck);

        //Make a standard deck of 52 cards
        Deck testDeck = new Deck(true);
//        //Test shuffle
//        testDeck.shuffle();

//        //test to create a hand, add cards to it and print
//        Hand testHand = new Hand();
//        testHand.takeCardFromDeck(testDeck);
//        testHand.takeCardFromDeck(testDeck);
//        testHand.takeCardFromDeck(testDeck);
//        System.out.println("testHand now has the following cards:");
//        System.out.println(testHand);
//        System.out.println("testDeck now looks like this:");
//        System.out.println(testDeck);

//       //  check this part again
//        testDeck.addCard(new Card(Suit.CLUB, Rank.ACE));
//        testDeck.addCard(new Card(Suit.HEART, Rank.ACE));
//        testDeck.addCard(new Card(Suit.DIAMOND, Rank.ACE));
//        testDeck.addCard(new Card(Suit.SPADE, Rank.ACE));
//        Hand testHand = new Hand();
//        testHand.takeCardFromDeck(testDeck);
//        testHand.takeCardFromDeck(testDeck);
//        testHand.takeCardFromDeck(testDeck);
//        testHand.takeCardFromDeck(testDeck);
//        System.out.println("The value of this hand is: " + testHand.calculatedValue());

//        //Testing the dealer class
//        Dealer myDealer = new Dealer();
//        System.out.println("The dealer's name is: " + myDealer.getName());

//        //Testing the Player class
//        Player myPlayer = new Player();
//        System.out.println("The Player's name is: " + myPlayer.getName());



    }
}
