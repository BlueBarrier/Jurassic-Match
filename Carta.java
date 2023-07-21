import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta extends Actor 
{
    private GreenfootImage caraArriba;
    private GreenfootImage caraAbajo;
    private boolean volteada;
    
    public Carta(GreenfootImage caraArriba, GreenfootImage caraAbajo){
        this.caraArriba = caraArriba;
        this.caraAbajo = caraAbajo;
        volteada= false;
        setImage(caraAbajo);
    }
    public void voltear(){
        if (volteada){
            setImage(caraAbajo);
        } else{
            setImage(caraArriba);
        }
        volteada = !volteada;
    }
    public boolean estaBocaArriba(){
        return volteada;
    }
}
