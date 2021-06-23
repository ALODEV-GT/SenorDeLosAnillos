package clases;

public class Humano extends Heroe {
    private static final String NOMBRE = "HUMANO ";
    private static final int VIDA_INICIAL = 180;
    private static int contador = 1;

    public Humano() {
        super(NOMBRE + contador++, VIDA_INICIAL);
    }
}
