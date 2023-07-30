import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que crea los niveles
 * 
 * @author Erick Barrera 
 * @version 20/07/2023
 */
public class Niveles extends World{
    private Niveles nivelInstancia;
    private ArrayList<Carta> cartasSelec;
    private Timer temporizador;
    private String nivelAct;
    public int contadorAciertos = 0;
    private boolean pantallaFinalizadaMostrada = false;
    public Actor clickedActor;
    public Carta carta;
    /**
     * Constructor de Niveles.
     * 
     */
    
    public Niveles(String[] cartitas, String fondo,String nivel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        super(1080, 720, 1);
        setear(cartitas);
        GreenfootImage imgFondo = new GreenfootImage(fondo);
        setBackground(imgFondo);
        temporizador = new Timer();
        addObject(temporizador, getWidth() / 2, 20); // Posición en la parte superior central del mundo
        nivelAct = nivel;
        cartasSelec = new ArrayList<>();
    }
    public void pares(String tiempo,String nivel){
        contadorAciertos = contadorAciertos +1;
        if(contadorAciertos>=5){
            PantallaFinalizado pantallaComplete = new PantallaFinalizado(tiempo,nivel);
            Greenfoot.setWorld(pantallaComplete);
            pantallaFinalizadaMostrada = true;
        }
    }
    private void setear(String[] cartitas){
        GreenfootImage[] anverso = new GreenfootImage[10]; 
        
        for(int i=0;i<10;i++){
            anverso[i] = new GreenfootImage(cartitas[i]); 
        }
        
        GreenfootImage reverso = new GreenfootImage("images/cartaAbajo.png"); 
        Carta[] cartas = new Carta[10];
        for(int i=0; i < 10; i++){
            cartas[i] = new Carta(anverso[i],reverso,cartitas[i]);
        }
        List<Carta> listaCartas = new ArrayList<>();
        for(int i=0; i<10;i++){
            listaCartas.add(cartas[i]);
        }
        Collections.shuffle(listaCartas);
        for(int i=0;i<10;i++){
            cartas[i]=listaCartas.get(i);
        }
        int xInicial = 100;
        int yInicial = 100;
        for(int i=0;i<5;i++){
            addObject(cartas[i], xInicial+(i*250),yInicial);
        }
        for(int i =5;i<10;i++){
            addObject(cartas[i], xInicial+((i-5)*250),yInicial+250);
        }
    }
    public void act(){
        Actor clickedActor = Greenfoot.getMouseInfo().getActor();
        if (clickedActor instanceof Carta){
            Carta carta = (Carta) clickedActor;
        if (Greenfoot.mouseClicked(carta) && !carta.getAcertada() && !carta.getSelec()) {
            carta.setImagen(carta.getCaraArriba());
            carta.setImage(carta.getCaraArriba());
            cartasSelec.add(carta);
            carta.setSelec(!carta.getSelec());
            if (cartasSelec.size() == 2) {
                comprobar(this.getTiempo(), this.getNivel(),cartasSelec);
            }
        }
    }
    }
    public void reintentar(ArrayList<Carta> cartasSelec){
        Carta carta1 = cartasSelec.get(0);
        Carta carta2 = cartasSelec.get(1);
        
        boolean condicion = carta1.getSelec() && carta2.getSelec();
        if (condicion) {
            carta1.setImagen(carta1.getCaraAbajo());
            carta2.setImagen(carta2.getCaraAbajo());
            carta1.setImage(carta1.getCaraAbajo());
            carta2.setImage(carta2.getCaraAbajo());
            carta1.setSelec(!carta1.getSelec());
            carta2.setSelec(!carta2.getSelec());
            cartasSelec.clear();
        }
    }
    public void comprobar(String tiempo,String nivel,ArrayList<Carta> cartasSelec){
        Carta s1 = cartasSelec.get(0);
        Carta s2 = cartasSelec.get(1);
        String nombreCartaS1 = s1.getRuta();
        String nombreCartaS2 = s2.getRuta();
        boolean condicion = nombreCartaS1 == nombreCartaS2;
        if(condicion){
            s1.setAcertada(true);
            s2.setAcertada(true);
            pares(tiempo,nivel);
            cartasSelec.clear();
        } else{
            reintentar(cartasSelec);
        }
    }
    
    
    public String getTiempo(){
        return Integer.toString(temporizador.getSegundosTranscurridos());
    }
    public String getNivel(){
        return nivelAct;
    }
}
