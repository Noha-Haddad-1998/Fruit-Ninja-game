package game;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Arcade extends BasicGameState {
		Pineapple Pineapple=new Pineapple();
	Orange Orange=new Orange();
	Bombs Bomb =new Bombs();
	Banana Banana=new Banana();
	Dynamite Dynamite=new Dynamite();
	Juice Juice=new Juice();
	Cocktail Cocktail=new Cocktail();
	GameController gcontrol=new GameController();
	Mango Mango=new Mango();
    ArrayList<GameObject>go=new ArrayList<GameObject>();
    public String Score=" ";
    public String Lives=" ";
    int score=0;
    int maxscore;
    TrueTypeFont font3;
    int x;
    int y;
    int flag=0;
    int lives=3;
    int bonus;
    Image background2;
    int k=0;
    Sound sound;
    int lol=0;
    int time=0;
    TrueTypeFont font;
    TrueTypeFont font2;
    Image shutdown;
    Image reset;
    Image pause;
    Image back;
    Sound swip;
	public Arcade(int state) {
		
	}
	public void saveGame() {
		try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

        Element root = doc.createElement("score");
        doc.appendChild(root);
    
        String x=Integer.toString(score);
        root.appendChild(doc.createTextNode(x));
      
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("story2.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
	   }
	public void loadGame() {
		   try {
		SAXParserFactory factory = SAXParserFactory.newInstance();
						javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();

						DefaultHandler handler = new DefaultHandler() {

						public void startElement(String uri, String localName,String qName, 
					                Attributes attributes) throws SAXException {

							}
						public void endElement(String uri, String localName,
							String qName) throws SAXException {
		}

						public void characters(char ch[], int start, int length) throws SAXException {

					                String left=null;
					                
					               
					                          
					                left=new String(ch, start , length );
					            
		                        left=new String(ch, start, length);

								maxscore=Integer.parseInt(left);
								System.out.println("Arcade high score is:");
								System.out.println(maxscore);
						}
					     };
					       saxParser.parse("story2.xml", handler);			 
					     } catch (Exception e) {
					       e.printStackTrace();
					     }
					
					    
					    
					    
		  
		  }
	public void fillArray() {

	    Random r = new Random();
	    int m = r.nextInt(5)+15;
        for (int i = 0; i < m; i++) {
        GameObject G = gcontrol.CreateGameObject();
          
	       if(G instanceof Banana)
	       {  int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   { flag=0;
	    		   if(go.get(k) instanceof Banana )
	    			   flag=1;}
	    		   if(flag==0)
	    	        go.add(Banana);
	    	   
	    	   
	    	   }	       
	     
	       if(G instanceof Orange)
	       {
	    	    int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   {
	    		   if(go.get(k) instanceof Orange )
	    			   flag=1;}
	    		   if(flag==0)
	    	   go.add(Orange);	       }
	      
	       if(G instanceof Cocktail)
	       {
	    	    int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   {
	    		   if(go.get(k) instanceof Cocktail )
	    			   flag=1;}
	    		   if(flag==0)
	    	   go.add(Cocktail);	       }
	       if(G instanceof Juice)
	       {
	    	     int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   {
	    		   if(go.get(k) instanceof Juice )
	    			   flag=1;}
	    		   if(flag==0)
	    	   go.add(Juice);	       }
	       if(G instanceof Pineapple)
	       {
	    	   int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   {
	    		   if(go.get(k) instanceof Pineapple )
	    			   flag=1;}
	    		   if(flag==0)
	    	   go.add(Pineapple);	       }
	       if(G instanceof Mango)
	       {
	    	   int flag=0;
	    	   for(int k=0;k<go.size();k++)
	    	   {
	    		   if(go.get(k) instanceof Mango )
	    			   flag=1;}
	    		   if(flag==0)
	    	   go.add(Mango);	       }
	       
	   }
	 
	   }
	public void init(GameContainer gc,StateBasedGame sbg) throws SlickException {
	

         background2 = new Image("res/background2.jpg");
         sound=new Sound("res/click.wav");
         swip=new Sound("res/swip.wav");
         pause=new Image("res/pause.png");
         shutdown=new Image("res/shutdown.png");
         reset=new Image("res/reset.png");
         back=new Image("res/back.png");
         Font awtFont = new Font("Times New Roman", Font.BOLD, 50);
      	  font = new TrueTypeFont(awtFont, false);
      	Font awtFont2 = new Font("Times New Roman", Font.BOLD, 50);
    	  font2 = new TrueTypeFont(awtFont2, false);
    	  Font awtFont3 = new Font("Times New Roman", Font.BOLD, 50);
    	  font3 = new TrueTypeFont(awtFont3, false);
		fillArray();
		loadGame();
    
	}
	

	
	public void update(GameContainer gc,StateBasedGame sbg,int delta)throws SlickException{
	  
     
		int m=Mouse.getX();
		int n=Mouse.getY();
	    Lives="lives:"+lives;
		
	    Input input =gc.getInput();
	    Score="score: "+score;
	    time+=delta;
	   	  
	    if((m>1400 && m<=1495 ) && ( n>1407 && n<1497))
		{
			
			if(input.isMouseButtonDown(0)   )
				
				{sound.play();
				 go.clear();
				 lives=3;
				 score=0;
				 time=0;
				 Sys.alert(" ", " Game Reseted");
				 fillArray();
		        	
		        	for (int j=0;j<go.size();j++)
		        	{	 go.get(j).setYLocation(1500);
		        	     go.get(j).setXLocation(j);  
		        	     go.get(j).setMovingup(true);
		        	    
		        	}
                
				}
			}
		if((m>1400 && m<=1493 ) && ( n>1284 && n<1377))
		{
			if(input.isMouseButtonDown(0)   )
				
				{
				sound.play();
				 System.exit(0);
                
				}
			}
		if((m>1400 && m<=1494 ) && ( n>1046 && n<1137))
		{
			if(input.isMouseButtonDown(0)   )
				
				{ sound.play();
				go.clear();
				 lives=3;
				 score=0;
				 time=0;
				 k=0;
				 fillArray();
		        	
		        	for (int j=0;j<go.size();j++)
		        	{	 go.get(j).setYLocation(1500);
		        	     go.get(j).setXLocation(j);  
		        	     go.get(j).setMovingup(true);
		        	    
		        	}
				 sbg.enterState(3);
                
				}
			}
		if((m>1417 && m<=1481 ) && ( n>1185 && n<1244))
		{
			if(input.isMouseButtonDown(0)   )
				
				{
				sound.play();
				 Sys.alert("", "Game Paused");
                
				}
			}
	    
	    
	    
        for (int i = 0; i < go.size(); i++) {
        	
  	            if (  go.get(i).isMovingUp()) {
  	                  y = go.get(i).getYLocation();
  	                  y -= go.get(i).getVelocity()+k;
  	                  go.get(i).setYLocation(y);
  	               
  	            } else {
  	                y = go.get(i).getYLocation();
  	                y += go.get(i).getVelocity()+k;
  	                go.get(i).setYLocation(y);
  	                if(y>=1500)	
  	                	go.remove(i); 
  	                		
  	       	 
 	          
  	                	
  	            }
  	                	
  	        	     
  	           if(y<=0)
  	        	   go.get(i).setMovingup(false);
  	           
  
  	       
  	           if(input.isMouseButtonDown(0)) {
           	
          	  
  	        	 bonus=0;   
        for(int l=0;l<go.size();l++)
        {
        	
        	 int xg = go.get(l).getxloc();
             int yg = go.get(l).getYLocation();
               if ((input.getMouseX()>=xg && input.getMouseX()<xg+100) && (input.getMouseY() >= yg && input.getMouseY() < yg+100)) 
               {    	
            	   
            	   swip.play();
            
                if(go.get(l) instanceof Juice)
            	   
               {   score+=4;
            	   go.remove(l);
            	   bonus+=1;
            	  
               }
                else if(go.get(l) instanceof Cocktail)
            	   
               {
            	  score+=go.size();
                  go.clear();
               }
                else if(go.get(l) instanceof Mango)
             	   
                {
                	  score+=5;
               	      go.remove(l);
               	      bonus+=1;
                }
               
               
               else if(go.get(i) instanceof Banana||go.get(i) instanceof Orange||go.get(i) instanceof Pineapple ){  
            		   go.remove(l);
                       bonus++;
            	       score++;
            	   }}}
        if(bonus>1)
        	score+=bonus;
        
    	       }
  	         if(go.isEmpty() && (time/1000)<60)
        {
        	
        	fillArray();
        	for (int j=0;j<go.size();j++)
        	{	 go.get(j).setYLocation(1500);
        	     go.get(j).setXLocation(j);  
        	     go.get(j).setMovingup(true);
        	    
        	}
        	
        	 if(score>30)
    	     {
    	    	k=5;
    	     }
    	     if(score>70)
    	     {
    	    	 k=8;
    	     }
    	     if(score>100)
    	     {
    	    	 k=12;
    	     }   	
        }
  	         else
  	        	 {
  	        	 if(score>maxscore)
  	        		 saveGame();
  	        	 }
  	         
        }
        
        if(lol==0)
        {
        	if(time/1000==60)
        	{
        		Sys.alert("", "Game End\nYour Score : "+score);
        	sbg.enterState(3);
  	    lol=1;
        	}
        	if(lol==1)
        		{
        		go.clear();
				 score=0;
				 time=0;
				 lol=0;
				 k=0;
				 fillArray();
		        	
		        	for (int j=0;j<go.size();j++)
		        	{	 go.get(j).setYLocation(1500);
		        	     go.get(j).setXLocation(j);  
		        	     go.get(j).setMovingup(true);
		        	    
		        	}	
        	
  	    
        	}
        	
        }    	
  	        	 }
  	     
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g)throws SlickException{
		background2.draw(0, 0, 1500, 1500);
		font.drawString(0, 0, "Time: "+time/1000,Color.orange);
		font2.drawString(0, 50, "Score: "+score,Color.orange);
		reset.draw(1400, 0, 100, 100);
	    shutdown.draw(1400, 120, 100, 100);
	    pause.draw(1400, 240, 100, 100);
	    back.draw(1400, 360, 100, 100);
		if(maxscore>score)
			font3.drawString(0,100,"High Score: "+maxscore,Color.orange);
		else
			font3.drawString(0,100,"High Score: "+score,Color.red);

       
		for(int z=0;z<go.size();z++) {
	go.get(z).getImage().draw(go.get(z).getXLocation(),go.get(z).getYLocation(), 100, 100);
	}
	
	}
	
	public int getID() {
		
		return 2;
	}

}
