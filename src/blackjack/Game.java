package blackjack;

import java.util.Scanner;

public class Game {
    //Create variables used by the Game class
    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    //Constructor for Game, creates our variables and starts the Game
    public Game(){

        System.out.println("Enter the total amount you want to bet: ");
        Scanner input = new Scanner(System.in);
        double totalAmount = input.nextDouble();

        //Set the score to zero
        wins = 0; losses =0; pushes = 0;

        //Create a new deck with 52 cards
        deck = new Deck(true);

        //Create a new empty deck
        discarded = new Deck();

        //Create the People
        dealer = new Dealer();
        player = new Player();

        //Shuffle the deck and start the first round
        deck.shuffle();
        startRound(totalAmount);
    }

    //This  method will handle the logic for each round
    private void startRound(double totalAmount){

        double balanceAmount = totalAmount;
        double betAmount = 0.0;

        if (balanceAmount>0) {

            System.out.println("Enter the amount you want to bet for this round: ");
            Scanner input = new Scanner(System.in);
            betAmount = input.nextDouble();


            if (betAmount <= 0) {
                System.out.println("Invalid input. Please give a positive amount.");
                startRound(totalAmount);
            }

        }
            while ((balanceAmount) > 0) {

                if (wins > 0 || losses > 0 || pushes > 0) {
                    System.out.println();
                    System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
                    dealer.getHand().discardHandToDeck(discarded);
                    player.getHand().discardHandToDeck(discarded);
                }

                //Check to make sure the deck has at least 4 cards left
                if (deck.cardsLeft() < 4) {
                    deck.reloadDeckFromDiscard(discarded);
                }

                //Give the dealer two cards
                dealer.getHand().takeCardFromDeck(deck);
                dealer.getHand().takeCardFromDeck(deck);

                //Give the player two cards
                player.getHand().takeCardFromDeck(deck);
                player.getHand().takeCardFromDeck(deck);

                //Print their hands
                dealer.printFirstHand();
                player.printHand();

                //Check if dealer has BlackJack to start
                if (dealer.hasBlackjack()) {
                    //Show the dealer has BlackJack
                    dealer.printHand();

                    //Check if the player also has BlackJack
                    if (player.hasBlackjack()) {
                        //End the round with a push
                        System.out.println("You both have 21 - Push.");
                        pushes++;

                        //   balanceAmount = balanceAmount + betAmount;

                    } else {
                        System.out.println("Dealer has BlackJack. You lose.");
                        dealer.printHand();
                        losses++;

                        balanceAmount = balanceAmount - betAmount;

                    }
                    System.out.println("Remaining balance : " + balanceAmount);
                    startRound(balanceAmount);

                }

                //Check if player has blackjack to start
                //If we got to this point, we already know the dealer didn't have blackjack
                if (player.hasBlackjack()) {
                    System.out.println("You have Blackjack! You win!");
                    wins++;

                    balanceAmount = balanceAmount - betAmount + (betAmount * 1.5);
                    System.out.println("Remaining balance : " + balanceAmount);
                    startRound(balanceAmount);
                }

                //Let the player decide what to do next

                    player.makeDecision(deck, discarded);

                //Check if they busted
                if (player.getHand().calculatedValue() > 21) {
                    System.out.println("You have gone over 21.");
                    //count the losses
                    losses++;

                    balanceAmount = balanceAmount - betAmount;
                    System.out.println("Remaining balance : " + balanceAmount);

                    //start the round over
                    startRound(balanceAmount);
                }

                //Now it's the dealer's turn

                    dealer.printHand();
                    while (dealer.getHand().calculatedValue() < 17)
                        dealer.hit(deck, discarded);


                //Check who wins
                if (dealer.getHand().calculatedValue() > 21) {
                    System.out.println("Dealer busts");

                    balanceAmount = balanceAmount - betAmount + (betAmount * 2);
                    System.out.println("Remaining balance : " + balanceAmount);
                    wins++;
                } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
                    System.out.println("You lose.");
                    balanceAmount = balanceAmount - betAmount;
                    System.out.println("Remaining balance : " + balanceAmount);

                    losses++;

                } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
                    System.out.println("You win.");

                    balanceAmount = balanceAmount - betAmount + (betAmount * 2);
                    System.out.println("Remaining balance : " + balanceAmount);

                    wins++;
                } else {
                    System.out.println("Push.");

                    System.out.println("Remaining balance : " + balanceAmount);
                }

                //Start a new round
                startRound(balanceAmount);

            }

            System.out.println("GAME OVER !! You don't have any balance left");
            System.out.println("Wins: " + wins + " Losses: "+ losses + " Pushes: "+ pushes);
            System.exit(0);
    }

}
