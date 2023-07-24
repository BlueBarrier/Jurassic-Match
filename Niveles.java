import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que crea los niveles
 * 
 * @author Erick Barrera 
 * @version 20/07/2023
 */
public class Niveles extends Memoria{
    private Niveles nivelInstancia;
    private ArrayList<Carta> cartasSelec;
    private Timer temporizador;
    private String nivelAct;
    /**
     * Constructor de Niveles.
     * 
     */
    
    public Niveles(String[] cartitas, String fondo,String nivel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        
        setear(cartitas);
        GreenfootImage imgFondo = new GreenfootImage(fondo);
        setBackground(imgFondo);
        GreenfootImage textoNivel = new GreenfootImage(nivel, 100, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(textoNivel, (getWidth() / 2)-(textoNivel.getWidth()/2),100);
        temporizador = new Timer();
        addObject(temporizador, getWidth() / 2, 20); // Posición en la parte superior central del mundo
        nivelAct = nivel;
        cartasSelec = new ArrayList<>();
    }
    private void setear(String[] cartitas){
        GreenfootImage[] anverso = new GreenfootImage[10]; 
        
        for(int i=0;i<10;i++){
            anverso[i] = new GreenfootImage(cartitas[i]); 
        }
        
        GreenfootImage reverso = new GreenfootImage("images/cartaAbajo.png"); 
        Carta[] cartas = new Carta[10];
        for(int i=0; i < 10; i++){
            cartas[i] = new Carta(anverso[i],reverso,cartasSelec);
        }
        List<Carta> listaCartas = new ArrayList<>();
        for(int i=0; i<10;i++){
            listaCartas.add(cartas[i]);
        }
        Collections.shuffle(listaCartas);
        for(int i=0;i<10;i++){
            cartas[i]=listaCartas.get(i);
        }
        int xInicial = 100;
        int yInicial = 350;
        for(int i=0;i<5;i++){
            addObject(cartas[i], xInicial+(i*150),yInicial);
        }
        for(int i =5;i<10;i++){
            addObject(cartas[i], xInicial+((i-5)*150),yInicial+150);
        }
    }
    public void act(){
       List<Carta> actores = getObjects(Carta.class); 
       for(Carta actor : actores){
            actor.voltear(this.getTiempo(),this.getNivel(),cartasSelec);
       }
    }
    
    
    
    public String getTiempo(){
        return Integer.toString(temporizador.getSegundosTranscurridos());
    }
    public String getNivel(){
        return nivelAct;
    }
}
