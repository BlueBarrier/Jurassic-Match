/**
 * Write a description of class SelectorNiveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;
import java.util.Random;
public class SelectorNiveles extends World
{
    protected String[] cartitas1 = {"images/Nivel1/Tri1.png","images/Nivel1/Tri2.png","images/Nivel1/Tri3.png","images/Nivel1/Tri4.png","images/Nivel1/Tri5.png",
        "images/Nivel1/Tri1.png","images/Nivel1/Tri2.png","images/Nivel1/Tri3.png","images/Nivel1/Tri4.png","images/Nivel1/Tri5.png"};
    protected String[] cartitas2 = {"images/Nivel2/Jura1.png","images/Nivel2/Jura2.png","images/Nivel2/Jura3.png","images/Nivel2/Jura4.png","images/Nivel2/Jura5.png",
        "images/Nivel2/Jura1.png","images/Nivel2/Jura2.png","images/Nivel2/Jura3.png","images/Nivel2/Jura4.png","images/Nivel2/Jura5.png"};
    protected String[] cartitas3 = {"images/Nivel3/Creta1.png","images/Nivel3/Creta2.png","images/Nivel3/Creta3.png","images/Nivel3/Creta4.png","images/Nivel3/Creta5.png",
        "images/Nivel3/Creta1.png","images/Nivel3/Creta2.png","images/Nivel3/Creta3.png","images/Nivel3/Creta4.png","images/Nivel3/Creta5.png"};
    protected String[] fondo1 = {"images/Nivel1/Fondo T1.png", "images/Nivel1/Fondo T2.png","images/Nivel1/Fondo T3.png"};
    protected String[] fondo2 = {"images/Nivel2/Fondo J1.png", "images/Nivel2/Fondo J2.png","images/Nivel2/Fondo J3.png"};
    protected String[] fondo3 = {"images/Nivel3/Fondo C1.png", "images/Nivel3/Fondo C2.png","images/Nivel3/Fondo C3.png"};
    private Random rand;
    private int indiceRandom;
    // Variable nivel seleccionado
    private String nivelSeleccionado;
    // Variable estado de pantalla de inicio 
    private boolean enPantallaInicio;
    BotonesNiveles botonNivel1 = new BotonesNiveles("Triácico", 160);
    BotonesNiveles botonNivel2 = new BotonesNiveles("Jurásico", 160);
    BotonesNiveles botonNivel3 = new BotonesNiveles("Cretácico", 160);
    
    // Método de inicialización del mundo
    public void prepare(){
        // Agrega los botones para los tres niveles
        
        addObject(botonNivel1, 600, 220);
        addObject(botonNivel2, 600, 320);
        addObject(botonNivel3, 600, 420);
    }

    public void act()
    {
        // Verifica si se está en la pantalla de inicio
        if (enPantallaInicio)
        {
            // Verifica clic en algún botón de nivel
            if (Greenfoot.mouseClicked(null))
            {
                Actor clickedActor = Greenfoot.getMouseInfo().getActor();
                if (clickedActor instanceof BotonesNiveles){
                    BotonesNiveles botonNivel = (BotonesNiveles) clickedActor;
                    if(botonNivel.getTexto() == "Triácico"){
                        nivelSeleccionado = "Triásico";
                    }else if (botonNivel.getTexto() == "Jurásico"){
                        nivelSeleccionado = "Jurásico";
                    }else if (botonNivel.getTexto() == "Cretácico"){
                    nivelSeleccionado = "Cretácico";
                    }
                }
                // Si se seleccionó un nivel, cambia al mundo del nivel correspondiente
                if (!nivelSeleccionado.equals("")) {
                    enPantallaInicio = false;
                    cambiarNivel();
                }
            }
        }
    }
    
    private void cambiarNivel(){
        // Cambiar al mundo del nivel seleccionado
        Random r1 = new Random();
        indiceRandom = r1.nextInt(3);
        Niveles nivel1 = new Niveles(cartitas1,fondo1[indiceRandom],"Triácico");
        Niveles nivel2 = new Niveles(cartitas2,fondo2[indiceRandom],"Jurásico");
        Niveles nivel3 = new Niveles(cartitas3,fondo3[indiceRandom],"Cretácico");
        if (nivelSeleccionado.equals("Triácico")) {
            Greenfoot.setWorld(nivel1);
        }
        else if (nivelSeleccionado.equals("Jurásico")) {
            Greenfoot.setWorld(nivel2);
        }
        else if (nivelSeleccionado.equals("Cretácico")) {
            Greenfoot.setWorld(nivel3);
        }
    }
    public SelectorNiveles(){    
        super(800, 600, 1);
        // Inicializa las variables
        nivelSeleccionado = "";
        setBackground("images/Jurassic Match.png");
        enPantallaInicio = true;
        // Llama al método de inicialización del mundo
        prepare();
    }
}
