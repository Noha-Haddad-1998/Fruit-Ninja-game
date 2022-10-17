package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

    public interface GameObject {
   public int getxloc();
     
    public int getXLocation(); 
     
    public void slice(boolean s);
    
    public boolean isSliced();
    
    public int getYLocation();
   
    
    public void setXLocation(int x);
    
    public void setYLocation(int y);
    
    public Image getImage() throws SlickException ;

    public boolean isMovingUp();
    
    public void setMovingup(boolean movingUp);
    
    public int getVelocity();
    public int getflag() ;
    public int setflag(int x);
    
}
