import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Memoria extends World{
    private String opcion;
    protected String[] cartitas1;
    protected String[] cartitas2;
    protected String[] cartitas3;
    protected String fondo1;
    protected String fondo2;
    protected String fondo3;
    private boolean pantallaInit;
    public void botones(){
        BotonesNiveles botonHistoria = new BotonesNiveles("Modo Historia");
        BotonesNiveles botonSelectNivel = new BotonesNiveles("Selector de Niveles");
        addObject(botonHistoria, 400, 200);
        addObject(botonSelectNivel, 400, 300);
    }
    public void act()
    {
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
                    pantallaInit = false;
                    cambiarNivel();
                }
            }
        }
    }
    private void cambiarNivel(){
        // Cambiar al mundo del nivel seleccionado
        Niveles nivel1 = new Niveles(cartitas1, fondo1);
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
        botones();
    }
}

