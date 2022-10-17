package game;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
Image background;
Image start;
Image exit;
Music music;
Sound soundeffect;
	public String mouse="No Input Yet! ";
	public Menu(int state) {
		
	}
	public void init(GameContainer gc,StateBasedGame sbg) throws SlickException {
		 background=new Image("res/back23.jpg");
		 start=new Image("res/Start 2.png");
		 exit=new Image("res/Exit 2.png");
	     soundeffect=new Sound("res/click.wav");
	     
		 music=new Music("res/backmusic.ogg");
         music.setVolume(0.2f);
	     music.loop();
	}
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g)throws SlickException{
		
	
		background.draw(0, 0, 1500, 1500);
		start.draw(50, 300, 500, 500);
		exit.draw(50,859,500,500);
		
	
		
	}
	public void update(GameContainer gc,StateBasedGame sbg,int delta)throws SlickException{
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		mouse="Mouse Position X= "+xpos+"Y= "+ypos;
		Input input =gc.getInput();
		if((xpos<583 && xpos>=71 ) && ( ypos>729 && ypos<1148))
		{
			if(input.isMouseButtonDown(0)   )
				
				{
				soundeffect.play(); 		
				sbg.enterState(3);
				 Sys.alert("Instructions", "Classic Mode\n\n1)Slicing Cocktail: Slice all fruits in the screen and add on all sliced bonus\n2)Slicing OrangeJuice: Add 4 points bonus\n3)Slicing MangoJuice: Add 1 more live\n4)Slicing Bomb: Decrease live by 1\n5)Slicing Dynamite: Losing all your life and end game immediately\n6)Any other fruit add 1 point bonus when slicing\n7)Dropped fruit decrease live by 1\n---------------------------------------------\nArcade Mode\n\nPlay untill you beat your best high score\nLimited Time 60 Seconds");
				
				}
			}
		
		if((xpos<514&& xpos>78 ) && ( ypos>240 && ypos<609))
		{
			if(input.isMouseButtonDown(0)   )
				System.exit(0);
		}
		
		
	}
	public int getID() {
	
		return 0;
	}
	
  
}