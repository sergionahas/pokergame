/*********************************
 * Test class for Player Class
 * by Sergio Nahas
 * ********************************/

public class PlayerTest{
    public static void main(String[] args){
        
        Player P = new Player();
        Deck cards = new Deck();
        cards.shuffle();
        for(int i=0; i<5; i++){
            P.addCard(cards.deal());    //create a hand of 5 cards (1)
        }
        System.out.println("Before Sorting:");
        P.getHand();
        
        P.sort(); //sort my hand
        System.out.println("After Sorting:");
        P.getHand();
    }
    
}