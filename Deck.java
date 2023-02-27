
//add your own banner here

public class Deck {
	
	private Card[] cards;
	private int top; //the index of the top of the deck

	
	
	public Deck(){
		top = 0;
        
                           
        cards = new Card[52];
        
            
        
            for(int j=1; j<14; j++){
                cards[j-1] = new Card(1, j);   //populate clubs(1)
            }
            for(int k=14; k<27; k++){
                cards[k-1] = new Card(2, k-13);  //populate diamonds(2)
            }
            for(int l=27; l<40; l++ ){
                cards[l-1] = new Card(3, l-26);  //populate hearts(3)
            }   
            for(int p=40; p<53; p++){
                cards[p-1] = new Card(4,p-39);   //populate spades(4)
            } 
        
        }
	
	
	public void shuffle(){
		for(int i=0; i<200; i++){
            int random1 = (int) (Math.random()*(52));
            int random2 = (int) (Math.random()*(52));
            
            Card temp = cards[random1];
            cards[random1] = cards[random2];
            cards[random2] = temp;
            
        }
	}
	
	public Card deal(){
        if (top > 51) {
            top = 0;
        }
        int temp = top;
        top = top+1;
		return cards[temp];  
        
	}
	
	public void getMyDeck(){    //for DeckTester
        for(int j=0; j<52; j++){
            System.out.println(cards[j]);
        }
    }

}
