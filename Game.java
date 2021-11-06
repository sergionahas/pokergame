/***********************************************\
 * Game class for PP4
 * by Sergio Nahas - sn2865
 ************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
	private Player p;
	private Deck cards;
	private int odds;
    private ArrayList<Card> testerArray;
	
	
	public Game(String[] testHand){

        p = new Player();    //creates a new player
        cards = new Deck();  //creates a new deck of 52 cards
        
        odds = 0; //odds start at 0
        
        testerArray = new ArrayList<Card>();
        
        
        for(int j=0; j<5; j++){
            String card = testHand[j];
            Card myCard;
            if((card.substring(0,1)).equals("c")){
                myCard = new Card(1, Integer.parseInt(card.substring(1, card.length() -1)));      
            }
            else if((card.substring(0,1)).equals("d")){
                myCard = new Card(2, Integer.parseInt(card.substring(1, card.length() -1)));
            }
            else if((card.substring(0,1)).equals("h")){
                myCard = new Card(3, Integer.parseInt(card.substring(1, card.length() -1)));
            }
            else if((card.substring(0,1)).equals("s")){
                myCard = new Card(4, Integer.parseInt(card.substring(1, card.length() -1)));
            }
            else{
                myCard = null;
            }
            p.addCard(myCard);
        }
        p.sort();
        System.out.println("This is your hand: ");
        p.getHand();
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
		
	}
	
	public Game(){
		p = new Player();
        cards = new Deck();
		
	}
	
	public void play(){         // this method should play the game	
		
        Scanner scanner = new Scanner(System.in);
        
        
        cards.shuffle(); //always start by shuffling cards (0)
        
        System.out.println("How much do you want to bet ? ");
        double bet = scanner.nextDouble();
        p.bets(bet);
        
        for(int i=0; i<5; i++){
            p.addCard(cards.deal());    //create a hand of 5 cards (1)
        }
        p.sort(); //sort my hand
        
        System.out.println("Your hand is: ");
        p.getHand();
        
        
        //Lets's see which cards the player wants to keep or remove (3)
        System.out.println("Do you want to keep Card1 ? Y or N"); //1
        String choice1 = scanner.next();
        
        System.out.println("Do you want to keep Card2 ? Y or N"); //2
        String choice2 = scanner.next();
        
        System.out.println("Do you want to keep Card3 ? Y or N"); //3
        String choice3 = scanner.next();
        
        System.out.println("Do you want to keep Card4 ? Y or N"); //4
        String choice4 = scanner.next();
        
        System.out.println("Do you want to keep Card5 ? Y or N"); //5
        String choice5 = scanner.next();
        
        //Let's change the cards that the player doesn't want
        //issue: once I remove one of the cards, the position change
        
        Card temp1 = p.getHandCard(0);
        Card temp2 = p.getHandCard(1);
        Card temp3 = p.getHandCard(2);
        Card temp4 = p.getHandCard(3);
        Card temp5 = p.getHandCard(4);
        
        if(choice1.equals("N")){
            p.removeCard(temp1);  //1
            p.addCard(cards.deal());
        }
        if(choice2.equals("N")){
            p.removeCard(temp2);  //2
            p.addCard(cards.deal());
        }
        if(choice3.equals("N")){
            p.removeCard(temp3);  //3
            p.addCard(cards.deal());
        }
        if(choice4.equals("N")){
            p.removeCard(temp4);  //4
            p.addCard(cards.deal());
        }
        if(choice5.equals("N")){
            p.removeCard(temp5);  //5
            p.addCard(cards.deal());
        }
        
        p.sort(); //sort the new hand
        
        System.out.println("Your new hand is : ");
        p.getHand(); //prints the new hand sorted
        
        String handCombination = checkHand(p.getHandArray());
        System.out.println("Your hand is: " + handCombination);
        
        p.winnings(odds);
        
        System.out.println("You now have in your bankroll : " + p.getBankroll());
        
        
        
	}
    
    
    public void playTest(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How much do you want to bet ? ");
        double bet = scanner.nextDouble();
        p.bets(bet);
        
       
        
        
        
        String handCombination = checkHand(p.getHandArray());
        System.out.println("Your hand is: " + handCombination);
        
        p.winnings(odds);
        
        System.out.println("You now have in your bankroll : " + p.getBankroll());
        
    }
	
	public String checkHand(ArrayList<Card> hand){
		
        
        
        if(royalFlush(hand)){
            odds = 250;
            return "Royal Flush";
        }
        else if (straightFlush(hand)){
            odds = 50;
            return "Straight Flush";
        }
        else if (fourKind(hand)){
            odds = 25;
            return "Four of a Kind";
        }
        else if (fullHouse(hand)){
            odds = 6;
            return "Full House";
        }
        else if (flush(hand)){
            odds = 5;
            return "Flush";
        }
        else if (straight(hand)){
            odds = 4;
            return "Straight";
        }
        else if (threeKind(hand)){
            odds = 3;
            return "Three of a Kind";
        }
        else if (twoPair(hand)){
            odds = 2;
            return "Two Pair";
        }
        else if (onePair(hand)){
            odds = 1;
            return "One Pair";
        }
        else{
            odds = 0;
            return "High Card";
        }
        
        
            
		
	}
	
    public boolean royalFlush(ArrayList<Card> hand){
        return((straightFlush(hand)) && (hand.get(0).getRank() == 1) && (hand.get(4).getRank() == 13));
    }
	
    public boolean straightFlush(ArrayList<Card> hand){
        return (flush(hand) && straight(hand));
    }
    
    
	public boolean fourKind(ArrayList<Card> hand){
        
        if(hand.get(0).getRank() == hand.get(3).getRank()){
            return true;
        }
        else if (hand.get(1).getRank() == hand.get(4).getRank()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean fullHouse(ArrayList<Card> hand){
        if((hand.get(0).getRank() == hand.get(2).getRank()) 
           && (hand.get(3).getRank() == hand.get(4).getRank())){
            return true;
        }
        else if((hand.get(0).getRank() == hand.get(1).getRank()) 
                && (hand.get(2).getRank() == hand.get(4).getRank()))
            return true;
        else{
            return false;
        }
    }
    
    public boolean flush(ArrayList<Card> hand){
        if(hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(2).getSuit()
              == hand.get(3).getSuit() && hand.get(4).getSuit() == hand.get(3).getSuit()
                 && hand.get(4).getSuit() == hand.get(0).getSuit()){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public boolean straight(ArrayList<Card> hand){
        if((hand.get(4).getRank()) == (hand.get(0).getRank() + 4)){
            return true;
        }
        else if((hand.get(0).getRank() == 1) && (hand.get(4).getRank() == 13)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean threeKind(ArrayList<Card> hand){
        if(hand.get(0).getRank() == hand.get(2).getRank()){
            return true;
        }
        else if(hand.get(1).getRank() == hand.get(3).getRank()){
            return true;
        }
        else if(hand.get(2).getRank() == hand.get(4).getRank()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean twoPair(ArrayList<Card> hand){
        if(hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank()){
            return true;
        }
        else if(hand.get(0).getRank() == hand.get(1).getRank()
                 && hand.get(3).getRank() == hand.get(4).getRank()){
            return true;
        }
        else if(hand.get(1).getRank() == hand.get(2).getRank()
                 && hand.get(3).getRank() == hand.get(4).getRank()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean onePair(ArrayList<Card> hand){
        if(hand.get(0).getRank() == hand.get(1).getRank()){
            return true;
        }
        else if(hand.get(1).getRank() == hand.get(2).getRank()){
            return true;
        }
        else if(hand.get(2).getRank() == hand.get(3).getRank()){
            return true;
        }
        else if(hand.get(3).getRank() == hand.get(4).getRank()){
            return true;
        }
        else{
            return false;
        }
    }
    
   
}