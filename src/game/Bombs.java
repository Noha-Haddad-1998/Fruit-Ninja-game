package game;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bombs implements GameObject {
	Random r=new Random();
	int xinit=r.nextInt(1300);
	int xloc;
	Random R=new Random();
int random1=R.nextInt(2);
    int yloc=1500;
    int flag=0;
    int f1=0;
    int f2=0;

	Boolean movingup=true;
	Boolean sliced=false;


public void setXLocation(int x) {
  
	Random r=new Random();
	random1=r.nextInt(2);	
}
public int getXLocation() {
	if(random1==0)
	{
		random1=3;
		xinit=1000+r.nextInt(300);
		xloc=xinit;
	}
	else if(random1==1){
		random1=3;
		xinit=r.nextInt(300);
		xloc=xinit;
	}
	if((xinit<300 && xloc<1500 && f1==0) || (f2==1) )
	{xloc+=10;
	
	if(xloc>=1300)
		{f1=1;
		f2=0;
		
		}
	
	}
	
	else if((xinit>350 && xloc>0 && f2==0) || (f1==1) ) 
		{xloc-=10;
		if(xloc<=0)
	      {f2=1;
	      f1=0;
	      }
		}
	return  xloc;
}
public void setYLocation(int y) {
    this.yloc = y;
}

public void slice(boolean s) {

	this.sliced=s;
}


public boolean isSliced() {

	return sliced;
	
}

public int getYLocation() {

	return yloc;
}
public int getxloc() {
	// TODO Auto-generated method stub
	return xloc;
}
public boolean isMovingUp() {

	return movingup;
}

public void setMovingup(boolean moving) {

	this.movingup=moving;
}

public int getVelocity() {

	return 5;
}
public int getflag() {
	
	return flag;
}
public int setflag(int x) {
	
	return this.flag=x;
}
public Image getImage() throws SlickException
	{
		Image bomb=new Image("res/bomb.png");
	
		return bomb;
	}
}
