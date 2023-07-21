import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea los niveles
 * 
 * @author Erick Barrera 
 * @version 20/07/2023
 */
public class Niveles extends World
{
    private void setear(){
        GreenfootImage anverso1 = new GreenfootImage("C:/Users/Dann-/Programacion/POO/Minijuego/Jurassic Match/images/cartaArriba.jpg");
        GreenfootImage reverso = new GreenfootImage("C:/Users/Dann-/Programacion/POO/Minijuego/Jurassic Match/images/cartaAbajo.png");
        Carta[] cartas = new Carta[10];
        cartas[0]= new Carta(anverso1,reverso);
        addObject(cartas[0],100,100);
    }
    /**
     * Constructor for objects of class Niveles.
     * 
     */
    
    public Niveles()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
}
