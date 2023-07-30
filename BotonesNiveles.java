import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botonesNiveles here.
 * 
 * @author Luisa Jiménez 
 * @version (a version number or a date)
 */
public class BotonesNiveles extends Actor
{
    private int x;
    private String textoBoton;
    public BotonesNiveles(String texto, int x)
    {
        x = x;
        textoBoton = texto;
        GreenfootImage imagen = new GreenfootImage(x, 40);
        imagen.setColor(Color.BLACK);
        imagen.fill();
        imagen.setColor(Color.WHITE);
        imagen.drawRect(0, 0, x-1, 39);
        imagen.setFont(new Font("Verdana", 18));
        imagen.drawString(texto, (imagen.getWidth()/8), 25);
        setImage(imagen);
    }
    public String getTexto(){
        return textoBoton;
    }
    public void eliminarEsteActor() {
        World world = getWorld();
        if (world != null) {
            world.removeObject(this);
        }
    }
}
