import greenfoot.*;

public class Timer extends Actor
{
    private int segundosTranscurridos;
    private int contadorFotogramas;
    
    public Timer()
    {
        segundosTranscurridos = 0;
        contadorFotogramas = 0;
        actualizarImagen();
    }
    
    public void act()
    {
        contadorFotogramas++;
        
        
        if (contadorFotogramas >= 60) {
            segundosTranscurridos++;
            contadorFotogramas = 0;
            actualizarImagen();
        }
    }
    
    public int getSegundosTranscurridos()
    {
        return segundosTranscurridos;
    }
    
    private void actualizarImagen()
    {
        GreenfootImage imagen = new GreenfootImage("Tiempo: " + segundosTranscurridos + "s", 50, Color.BLACK, null);
        imagen.setFont(new Font("Verdana", 18));
        setImage(imagen);
    }
}



