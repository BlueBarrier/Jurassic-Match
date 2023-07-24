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
        GreenfootImage imagen = new GreenfootImage(200, 40);
        imagen.setColor(Color.BLACK);
        imagen.fill();
        imagen.setColor(Color.WHITE);
        imagen.drawRect(0, 0, 199, 39);
        imagen.setFont(new Font("Arial", 18));
        imagen.drawString(texto, (imagen.getWidth()/6), 25);
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
