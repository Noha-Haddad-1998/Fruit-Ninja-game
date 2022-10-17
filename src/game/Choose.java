package game;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Choose extends BasicGameState{

	Image background;
	Sound soundeffect;
	Image classic;
	Image arcade;
	Image back;
	public String mouse="No Input Yet! ";
	public Choose(int state) {
		
	}
	public void init(GameContainer gc,StateBasedGame sbg) throws SlickException {
		 background=new Image("res/back23.jpg");
		classic=new Image("res/classic3.png");
		arcade=new Image("res/arcade4.png");
	     soundeffect=new Sound("res/click.wav");
	     back=new Image("res/back.png");
	     
	}
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g)throws SlickException{
		
	
		background.draw(0, 0, 1500, 1500);
		classic.draw(100, 750, 400, 400);
		arcade.draw(50,1100,500,500);
		back.draw(1400, 0, 100, 100);
		
		
	}
	public void update(GameContainer gc,StateBasedGame sbg,int delta)throws SlickException{
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		mouse="Mouse Position X= "+xpos+"Y= "+ypos;
		Input input =gc.getInput();
		
		
		
		if((xpos>1400 && xpos<=1495 ) && ( ypos>1407 && ypos<1497))
		{
			if(input.isMouseButtonDown(0)   )
				
				{ soundeffect.play();
					
				 sbg.enterState(0);
                
				}
			}
		if((xpos>140 && xpos<460 ) && ( ypos>350 && ypos<672))
		{
			if(input.isMouseButtonDown(0)   )
				
				{
				soundeffect.play(); 		
				sbg.enterState(1);
				

                
				}
			}
		
		if((xpos<500&& xpos>108 ) && ( ypos>88 && ypos<215))
		{
			if(input.isMouseButtonDown(0)   )
				{
				soundeffect.play();
				sbg.enterState(2);
		}}
		
		
	}
	public int getID() {
	
		return 3;
	}
}
