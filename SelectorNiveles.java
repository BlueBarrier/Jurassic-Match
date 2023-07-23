/**
 * Write a description of class SelectorNiveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;

public class SelectorNiveles extends Memoria
{
    // Variable nivel seleccionado
    private String nivelSeleccionado;
    // Variable estado de pantalla de inicio 
    private boolean enPantallaInicio;
    BotonesNiveles botonNivel1 = new BotonesNiveles("Triácico");
    BotonesNiveles botonNivel2 = new BotonesNiveles("Jurásico");
    BotonesNiveles botonNivel3 = new BotonesNiveles("Cretácico");
    
    // Método de inicialización del mundo
    public void prepare(){
        // Agrega los botones para los tres niveles
        
        addObject(botonNivel1, 400, 200);
        addObject(botonNivel2, 400, 300);
        addObject(botonNivel3, 400, 400);
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
        Niveles nivel1 = new Niveles(cartitas1,fondo1);
        Niveles nivel2 = new Niveles(cartitas2,fondo2);
        Niveles nivel3 = new Niveles(cartitas3,fondo3);
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
        // Inicializa las variables
        nivelSeleccionado = "";
        enPantallaInicio = true;
        // Llama al método de inicialización del mundo
        prepare();
    }
}