/*************************************************
 * Card Class for PP4
 * by Sergio Nahas - sn2865
 */



import java.lang.Integer;
public class Card implements Comparable<Card>{
	
	private int suit; //use integers 1-4 to encode the suit    
	private int rank; //use integers 1-13 to encode the rank
	
	public Card(int s, int r){  //Constructor
		suit = s;
        rank = r;                
	}
	
	public int compareTo(Card c){
        int compareRank = Integer.compare(this.rank, c.rank);
        int compareSuit = Integer.compare(this.suit, c.suit);
        if(compareRank != 0){
            return compareRank;
        }
        else{
            return compareSuit;
        }
	}
	
	public String toString(){  //change from numerical suits to letters
		String description;
        String stringSuit = null;
        
        if(suit == 1){
            stringSuit = "Clubs";
        }
        else if(suit == 2){
            stringSuit = "Diamond";
        }
        else if(suit ==3){
            stringSuit = "Heart";
        }
        else if(suit ==4){
            stringSuit = "Spades";
        }
        
        description = "Suit: " + stringSuit;
        description += " Value: " + rank + "\n";
        
        return description;
	}
	
    public int getSuit(){
        return suit;
    }
    
    public int getRank(){
        return rank;
    }
}
