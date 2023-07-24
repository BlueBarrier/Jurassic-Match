import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PantallaFinalizado here.
 * 
 * @author Erick Barrera 
 * @version 23/07/2023
 */
public class PantallaFinalizado extends Memoria{
    private String opcion;
    private boolean pantallaInit;
    private String[] nextCartas;
    private String nextFondo;
    private boolean finalNivel = false;
    private void prepare(String totaltiempo){
        GreenfootImage texto = new GreenfootImage("¡Fin del nivel!", 30, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage tiempo = new GreenfootImage(totaltiempo, 30, Color.WHITE, new Color(0, 0, 0, 0));
        BotonesNiveles menu = new BotonesNiveles("Menú");
        BotonesNiveles siguiente = new BotonesNiveles("Siguiente Nivel");
        getBackground().drawImage(texto, getWidth() / 2 - texto.getWidth() / 2, getHeight() / 2 - texto.getHeight() / 2);
        addObject(menu, 400, 200);
        if (!finalNivel){
            addObject(siguiente, 400, 300);
        }
        getBackground().drawImage(tiempo,300,250);
    }
    public void act(String nivel){
        if (Greenfoot.mouseClicked(null))
            {
                Actor clickedActor = Greenfoot.getMouseInfo().getActor();
                if (clickedActor instanceof BotonesNiveles){
                    BotonesNiveles botonNivel = (BotonesNiveles) clickedActor;
                    if(botonNivel.getTexto() == "Menú"){
                        opcion = "Menú";
                    }else if (botonNivel.getTexto() == "Siguiente Nivel"){
                        opcion = "Siguiente Nivel";
                    }
                }
                // Si se seleccionó un nivel, cambia al mundo del nivel correspondiente
                if (!opcion.equals("")) {
                    pantallaInit = false;
                    cambiarNivel(nivel);
                }
            }
    }
    private void comprobarNivel(String nivelC){
        if(nivelC == "Triácico"){
            nextCartas = cartitas1;
            nextFondo = fondo1;
        }else if(nivelC == "Jurásico"){
            nextCartas = cartitas2;
            nextFondo = fondo2;
        }else if(nivelC == "Cretácico"){
            nextCartas = cartitas3;
            nextFondo = fondo3;
            finalNivel = true;
        }
    }
    private void cambiarNivel(String nivel){
        // Cambiar al mundo del nivel seleccionado
        Memoria menu = new Memoria();
        Niveles nivelsig = new Niveles(nextCartas,nextFondo,nivel);
        if (opcion.equals("Menú")) {
            Greenfoot.setWorld(menu);
        }
        else if (opcion.equals("Siguiente Nivel")) {
           Greenfoot.setWorld(nivelsig);
        }
    }
    public PantallaFinalizado(String tiempo, String nivel){
        comprobarNivel(nivel);
        prepare(tiempo);
    }
}
