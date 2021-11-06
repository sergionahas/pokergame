/**********************************
 * Test class for Card class
 * Sergio Nahas
 **********************************/

public class CardTest{
    public static void main(String[] args){
        Card C = new Card(1,1);
        System.out.println("Suit is: "+ C.getSuit());
        System.out.println("Rank is: "+ C.getRank());
    }
}