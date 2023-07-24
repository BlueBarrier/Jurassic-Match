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
    private int contadorAciertos;
    private ArrayList<Carta> cartasSelec;
    public Carta(GreenfootImage caraArriba, GreenfootImage caraAbajo,ArrayList<Carta> cartasSelec){
        this.caraArriba = caraArriba;
        this.caraAbajo = caraAbajo;
        volteada= false;
        acertada = false;
        setImage(caraAbajo);
        this.cartasSelec = cartasSelec;
    }
    public void voltear(String tiempo, String nivel, ArrayList<Carta> cartasSelec) {
        if (Greenfoot.mouseClicked(this) && !acertada) {
            if (volteada) {
                setImage(caraAbajo);
                cartasSelec.remove(this);
            } else {
                setImage(caraArriba);
                cartasSelec.add(this);
            }
            volteada = !volteada;
            Greenfoot.delay(30);
            if (cartasSelec.size() == 2) {
                comprobar(tiempo, nivel,cartasSelec);
            }
        }
    }

    public void comprobar(String tiempo,String nivel,ArrayList<Carta> cartasSelec){
        Carta cartaS1 = cartasSelec.get(0);
        Carta cartaS2 = cartasSelec.get(1);
        GreenfootImage imgCartaS1 = cartaS1.getImage();
        GreenfootImage imgCartaS2 = cartaS2.getImage();
        
        if(imgCartaS1.equals(imgCartaS2)){
            cartaS1.setAcertada(true);
            cartaS2.setAcertada(true);
            pares(tiempo,nivel);
        } else{
            cartaS1.voltear(tiempo,nivel,cartasSelec);
            cartaS2.voltear(tiempo,nivel,cartasSelec);
        }
        cartasSelec.clear();
    }
    private void pares(String tiempo,String nivel){
        contadorAciertos++;
        if(contadorAciertos>=5){
            PantallaFinalizado pantallaComplete = new PantallaFinalizado(tiempo,nivel);
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
    public GreenfootImage getCaraArriba(){
        return this.caraArriba;
    }
}
