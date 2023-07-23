import java.util.List;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que crea los niveles
 * 
 * @author Erick Barrera 
 * @version 20/07/2023
 */
public class Niveles extends Memoria{

    private Timer temporizador;

    private void setear(String[] cartitas){
        GreenfootImage[] anverso = new GreenfootImage[10]; 
        
        for(int i=0;i<10;i++){
            anverso[i] = new GreenfootImage(cartitas[i]); 
        }
        
        GreenfootImage reverso = new GreenfootImage("/images/cartaAbajo.png"); 
        Carta[] cartas = new Carta[10];
        
        int xInicial = 100;
        int yInicial = 100;
        int filas= 5;
        int columnas= 2;
        for(int i=0;i<10;i++){
             int x=xInicial + (i / columnas) * anverso[i].getWidth();
             int y=yInicial + (i%filas) * anverso[i].getWidth();
            cartas[i] = new Carta(anverso[i],reverso);
            addObject(cartas[i], x,y);
        }
        
    }
    public void act(){
       List<Carta> actores = getObjects(Carta.class); 
       for(Carta actor : actores){
            actor.voltear();
       }
    }
    /**
     * Constructor de Niveles.
     * 
     */
    
    public Niveles(String[] cartitas, String fondo)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        setear(cartitas);
        GreenfootImage imgFondo = new GreenfootImage(fondo);
        setBackground(imgFondo);
        temporizador = new Timer();
        addObject(temporizador, getWidth() / 2, 20); // Posición en la parte superior central del mundo
    }
}
