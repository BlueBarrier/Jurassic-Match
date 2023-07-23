import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Carta here.
 * 
 * @author Erick Barrera
 * @version 23/07/2023
 */
public class Carta extends Actor 
{
    private GreenfootImage caraArriba;
    private GreenfootImage caraAbajo;
    private boolean volteada;
    private boolean acertada;
    private ArrayList<Carta> cartasSelec;
    private int contadorAciertos;
    
    public Carta(GreenfootImage caraArriba, GreenfootImage caraAbajo){
        this.caraArriba = caraArriba;
        this.caraAbajo = caraAbajo;
        volteada= false;
        acertada = false;
        setImage(caraAbajo);
    }
    public void voltear(){
        if(Greenfoot.mouseClicked(null) && !acertada){
            Actor clickEnCarta = Greenfoot.getMouseInfo().getActor();
            if (clickEnCarta instanceof Carta && !acertada){
                setImage(caraArriba);
                volteada = true;
                Greenfoot.delay(30);
                if (cartasSelec.size() == 2){
                    comprobar();
                }
            }
            }
        
    }
    public void comprobar(){
        Carta cartaS1 = cartasSelec.get(0);
        Carta cartaS2 = cartasSelec.get(1);
        GreenfootImage imgCartaS1 = cartaS1.getImage();
        GreenfootImage imgCartaS2 = cartaS2.getImage();
        
        if(imgCartaS1.equals(imgCartaS2)){
            cartaS1.setAcertada(true);
            cartaS2.setAcertada(true);
        } else{
            cartaS1.voltear();
            cartaS2.voltear();
        }
        cartasSelec.clear();
    }
    private void pares(){
        contadorAciertos++;
        if(contadorAciertos>=5){
            // llamar función de cambiar nivel
        }
    }
    public int getPares(){
        return contadorAciertos;
    }
    public boolean getVolteada(){
        return volteada;
    }
    public boolean getAcertada(){
        return acertada;
    }
    public void setAcertada(boolean estado){
        this.acertada = estado;
    }
}
