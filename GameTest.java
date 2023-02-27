
public class GameTest{

    // this class must remain unchanged
    // your code must work with this test class
    
 
    public static void main(String[] args){
        if (args.length<1){
            Game g = new Game();
            while(true){
                g.play();
            }
        }
        else{
            Game g = new Game(args);
            g.playTest();
        }
    }

}
