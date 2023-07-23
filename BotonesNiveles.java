import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botonesNiveles here.
 * 
 * @author Luisa Jiménez 
 * @version (a version number or a date)
 */
public class BotonesNiveles extends Actor
{
    private String textoBoton;
    public BotonesNiveles(String texto)
    {
        textoBoton = texto;
        GreenfootImage imagen = new GreenfootImage(120, 40);
        imagen.setColor(Color.BLACK);
        imagen.fill();
        imagen.setColor(Color.WHITE);
        imagen.drawRect(0, 0, 119, 39);
        imagen.setFont(new Font("Arial", 18));
        imagen.drawString(texto, 25, 25);
        setImage(imagen);
    }
    public String getTexto(){
        return textoBoton;
    }
}
