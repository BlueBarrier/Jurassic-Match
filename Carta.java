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
    private GreenfootImage imagen;
    private boolean acertada;
    private boolean seleccionada;
    private String ruta;
    public Carta(GreenfootImage caraArriba, GreenfootImage caraAbajo,String ruta){
        this.ruta = ruta;
        this.caraArriba = caraArriba;
        this.caraAbajo = caraAbajo;
        acertada = false;
        seleccionada = false;
        setImage(caraAbajo);
        this.imagen = caraAbajo;
    }
    public String getRuta(){
        return ruta;
    }
    public boolean getSelec(){
        return seleccionada;
    }
    public void setSelec(boolean seleccion){
        this.seleccionada = seleccion;
    }
    public boolean getAcertada(){
        return acertada;
    }

    public void setAcertada(boolean estado){
        this.acertada = estado;
    }
    public GreenfootImage getCaraAbajo(){
        return caraAbajo;
    }
    public GreenfootImage getCaraArriba(){
        return caraArriba;
    }
    public void setImagen(GreenfootImage imagen){
        this.imagen = imagen;
    }
    public GreenfootImage getImagen(){
        return this.imagen;
    }
}
