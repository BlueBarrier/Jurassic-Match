import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Memoria extends World{
    private String opcion;
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
    private boolean pantallaInit;
    public BotonesNiveles botonHistoria = new BotonesNiveles("Modo Historia", 160);
    public BotonesNiveles botonSelectNivel = new BotonesNiveles("Selector de Niveles", 220);
    public void act()
    {
        addObject(botonHistoria, 610, 260);
        addObject(botonSelectNivel, 610, 330);
        // Verifica si se está en la pantalla de inicio
        if (pantallaInit)
        {
            // Verifica clic en algún botón de nivel
            if (Greenfoot.mouseClicked(null))
            {
                Actor clickedActor = Greenfoot.getMouseInfo().getActor();
                if (clickedActor instanceof BotonesNiveles){
                    BotonesNiveles botonNivel = (BotonesNiveles) clickedActor;
                    if(botonNivel.getTexto() == "Modo Historia"){
                        opcion = "Modo Historia";
                    }else if (botonNivel.getTexto() == "Selector de Niveles"){
                        opcion = "Selector de Niveles";
                    }
                }
                
                // Si se seleccionó un nivel, cambia al mundo del nivel correspondiente
                if (!opcion.equals("")) {
                    removeObjects(getObjects(BotonesNiveles.class));
                    pantallaInit = false;
                    cambiarNivel();
                }
            }
        }
    }
    private void cambiarNivel(){
        Random r1 = new Random();
        indiceRandom = r1.nextInt(3);
        // Cambiar al mundo del nivel seleccionado
        Niveles nivel1 = new Niveles(cartitas1, fondo1[indiceRandom],"Triásico");
        SelectorNiveles selector = new SelectorNiveles();
        if (opcion.equals("Modo Historia")) {
            Greenfoot.setWorld(nivel1);
        }
        else if (opcion.equals("Selector de Niveles")) {
            Greenfoot.setWorld(selector);
        }
    }
    /*
     * Constructor del juego
     * 
     */
    public Memoria(){ 
        super(800, 600, 1);
        opcion ="";
        pantallaInit= true;
        setBackground("images/Jurassic Match.png");
    }
}

