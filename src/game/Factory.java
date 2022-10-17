
package game;

public class Factory {
    public GameObject getGameObject(String name)
    {
        if(name.equals("Pineapple"))
            return new Pineapple();
        if(name.equals("Orange"))
            return new Orange();
        if(name.equals("Bombs"))
            return new Bombs();
        if(name.equals("Banana"))
            return new Banana();
        if(name.equals("Dynamite"))
            return new Dynamite();
        if(name.equals("Juice"))
            return new Juice();
        if(name.equals("Cocktail"))
            return new Cocktail();
        if(name.equals("Mango"))
            return new Mango();
        
        return null;
    }
}
