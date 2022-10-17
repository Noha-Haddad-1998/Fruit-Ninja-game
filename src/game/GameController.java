
package game;

import java.util.Random;

public class GameController implements GameActions {

    Factory f = new Factory();

    public GameObject CreateGameObject() {
        Random r = new Random();
        int m = r.nextInt(8);
        Random M=new Random();
        int c=M.nextInt(6);
        if (m == 0) {
            return f.getGameObject("Pineapple");
        } else if(m==1) {
            return f.getGameObject("Orange");
        }else if(m==2) {
            return f.getGameObject("Banana");
        }
        else if(m==3) {
            return f.getGameObject("Juice");
        }
        else if(m==4) {
            return f.getGameObject("Bombs");
        }
        else if(m==5) {
            return f.getGameObject("Cocktail");
        }
        else if(m==6)  {
            return f.getGameObject("Dynamite");
        }
        else
        	{
             if(c==0)
        	return f.getGameObject("Mango");
         
          
            	 }
		return null;
    }
}

