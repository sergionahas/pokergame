/************************************************
 * Player Class PP4
 * by Sergio Nahas - sn2865
 */


import java.util.ArrayList;
import java.util.Collections;
    
public class Player {
	
		
	private ArrayList<Card> hand; //the player's cards
	private double bankroll;
    private double bet;

	
		
	public Player(){		
	    hand = new ArrayList<Card>();  //array that will hold the cards in the player's hands
        bankroll = 5.0; //initial amount of money a player has
        bet = 0.0; //initial bet
	}

        public void addCard(Card c){
            hand.add(c);
        }

        public void removeCard(Card c){
            hand.remove(c);
        }
		
        public void bets(double amt){
            if(amt<= bankroll){
                bet += amt;
            bankroll = bankroll - bet;
            }
            else{
                System.out.println("You do not have enough money :(");
                bet = 0;
            }
        }

        public void winnings(int odds){
            bankroll += bet*odds;
            bet = 0;
        }

        public double getBankroll(){
            return bankroll;
        }

        public void getHand(){
            System.out.println(hand);
        }
        public Card getHandCard(int pos){
            return hand.get(pos);
        }
        
        public void sort(){
            Collections.sort(hand);
        }
        public ArrayList<Card> getHandArray(){ //returns it already sorted
            sort();
            return hand;
        }
}


