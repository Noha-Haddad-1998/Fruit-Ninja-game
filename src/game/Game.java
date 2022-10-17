package game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame {
	

public static final String gamename="FruitNinja";
public static final int menu=0;
public static final int level1=1;
public static final int arcade=2;
public static final int choose=3;
public Game(String gamename) {
	super(gamename);
	this.addState(new Menu(menu));
	this.addState(new Level1(level1));
	this.addState(new Choose(choose));
	this.addState( new Arcade(arcade));
}
	public void initStatesList(GameContainer gc) throws SlickException {
		//this.getState(menu).init(gc,this);
		//this.getState(choose).init(gc,this);
		
		//this.getState(level1).init(gc,this);
		
		 gc.setShowFPS(false);

	      //cap the frame rate (recommended)
	      gc.setTargetFrameRate(60);

	      //"cap" the delta value to some value you define, so that large
	      //spikes will not affect simple collision checking
	    //  gc.setMaximumLogicUpdateInterval(1000);
	      this.enterState(menu);
	}
	
public static void main(String[] args) {
		
   AppGameContainer appgc;
   try {
	   appgc=new AppGameContainer(new Game(gamename));
	   appgc.setDisplayMode(1500, 1500, false);
	   appgc.start();
   }catch(SlickException e){
	   e.printStackTrace();
   }
	}
	
	

}
