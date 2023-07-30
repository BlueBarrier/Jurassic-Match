import greenfoot.*; 
import java.util.Random;
public class PantallaFinalizado extends World {
    private String opcion;
    private String[] nextCartas;
    private String nextFondo;
    private boolean finalNivel = false;
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
    private String nivel;
    private String fondoFinal = "images/Final.jpg"; 
    private void prepare(String totaltiempo) {
        GreenfootImage texto = new GreenfootImage("¡Fin del nivel!", 70, Color.BLACK, new Color(0, 0, 0, 0));
        GreenfootImage tiempo = new GreenfootImage("Tu tiempo fue: " + totaltiempo + " segundos", 45, Color.BLACK, new Color(0, 0, 0, 0));
        tiempo.setFont(new Font("Verdana", 18));
        texto.setFont(new Font("Verdana", 18));
        BotonesNiveles menu = new BotonesNiveles("Menú", 160);
        BotonesNiveles siguiente = new BotonesNiveles("Siguiente Nivel", 220);
        // Botones
        addObject(menu, 610, 260);
        if (!finalNivel) {
            addObject(siguiente, 610, 330);
        }
        // mensajes
        getBackground().drawImage(texto, 100, 200);
        getBackground().drawImage(tiempo, 50, 350);
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Actor clickedActor = Greenfoot.getMouseInfo().getActor();
            if (clickedActor instanceof BotonesNiveles) {
                BotonesNiveles botonNivel = (BotonesNiveles) clickedActor;
                opcion = botonNivel.getTexto();
            }
            if (!opcion.equals("")) {
                cambiarNivel();
            }
        }
    }

    private void comprobarNivel(String nivelC) {
        Random r1 = new Random();
        indiceRandom = r1.nextInt(3);
        if (nivelC.equals("Triácico")) {
            nivel = "Jurásico";
            nextCartas = cartitas2;
            nextFondo = fondo2[indiceRandom];
        } else if (nivelC.equals("Jurásico")) {
            nivel = "Cretácico";
            nextCartas = cartitas3;
            nextFondo = fondo3[indiceRandom];
        } else if (nivelC.equals("Cretácico")) {
            finalNivel = true;
        }
    }

    private void cambiarNivel() {
        if (opcion.equals("Menú")) {
            Greenfoot.setWorld(new Memoria());
        } else if (opcion.equals("Siguiente Nivel")) {
            Greenfoot.setWorld(new Niveles(nextCartas, nextFondo, nivel)); // Asegúrate de tener el atributo nivel definido en la clase
        }
    }

    public PantallaFinalizado(String tiempo, String nivel) {
        super(800, 600, 1);
        setBackground("images/Final.jpg");
        comprobarNivel(nivel);
        prepare(tiempo);
    }
}
